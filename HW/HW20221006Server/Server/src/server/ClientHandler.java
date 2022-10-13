package server;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Server server; // екземпляр сервера

    private PrintWriter outMessage; // вихідне повідомлення

    private Scanner inMessage; // вхідне повідомлення

    // вузол та порт для відправки повідомлень
    private static final String HOST = "localhost";
    private static final int PORT = 3443;

    private Socket clientSocket = null; // сокет клієнта

    private static int clients_count = 0; // кількість клієнтів у чаті (статичне поле)


    // конструктор обробника для клієнта, що приймає сокет клієнта та сервер
    public ClientHandler(Socket socket, Server server) {
        try {
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Перевизначення методу run(), що викликається при створенні нового потоку (new Thread(client).start();)
    @Override
    public void run() {
        try {
            while (true) {
                // -----------------------------------------------------------------------------------------------------
                // отримання даних з БД - колекція
                List<Place> places = Db.getAllPlaces();

                // серіалізація колекції
                Gson gson = new Gson();
                String jsonListPlaces = gson.toJson(places);

                // відправка рядка усім
                // -----------------------------------------------------------------------------------------------------

//                // сервер відправляє повідомлення
//                server.sendMessageToOllClients("Новий учасник увійшов до чату!");
//                server.sendMessageToOllClients("Учасників у чаті - " + clients_count);
                server.sendMessageToOllClients(jsonListPlaces);
                break;
            }

            while (true) {
                // якщо від клієнта прийшло повідомлення
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();

                    // ##session##end## - якщо клієнт відправив дане повідомлення - цикл переривається, та клієнт виходить з чату
                    //if (clientMessage.equalsIgnoreCase("##session##end##")) {
                    if (clientMessage.contains("##session##end##")) {
//                        String clientName = clientMessage.substring("##session##end##".length());
//                        server.removeClientName(clientName);
                        break;
                    }

                    // додавання імені нового клієнта до списку імен після отримання послідовності символів ##client##name##
                    if (clientMessage.contains("##client##name##")) {
//                        String newName = clientMessage.substring("##client##name##".length());
//                        server.addNewClientName(newName);
//                        server.sendMessageToOllClients(server.getClientsNamesString());
                    } else {
                        // виведення повідомлення в консоль сервера - для тестування
                        System.out.println(clientMessage);

                        //----------------------------------------------------------------------------------------------
                        // десеріалізація повідомлення
                        Gson gson = new Gson();
                        List<Place> list = new ArrayList<>();
                        List<Place> placesFromClient = gson.fromJson(clientMessage, list.getClass());

                        // тестове повідомлення в консоль сервера
                        System.out.println("Десеріалізоване повідомлення від клієнта");
                        placesFromClient.forEach(System.out::println);

                        // завантаження даних до БД
                        for (Place place : placesFromClient) {
                            Db.insertPlace(place);
                        }

                        // отримання повного вмісту з БД в колекції
                        List<Place> places = Db.getAllPlaces();

                        // серіалізація колекції - (отримується рядок для відправлення клієнтам)
                        String jsonListPlaces = gson.toJson(places);
                        //----------------------------------------------------------------------------------------------

                        // відправлення повідомлення усім клієнтам
                        server.sendMessageToOllClients(jsonListPlaces);
                    }
                }
                // пауза в роботі потоку на 100 мс
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }

    // відправлення повідомлення
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // вихід клієнта з чату - не працює коли робота клієнта завершується не натисканням Х на вікні !!!
    public void close() {
        // видалення клієнта зі списку
        server.removeClient(this);
        clients_count--;
//        server.sendMessageToOllClients("Учасників у чаті - " + clients_count);
//        server.sendMessageToOllClients(server.getClientsNamesString());
    }
}
