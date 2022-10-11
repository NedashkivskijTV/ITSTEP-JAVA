package edu.itstep.hw20220929.ServerOnJava;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    // порт, що буде прослуховуватись сервером
    static final int PORT = 3443;

    // список клієнтів, які будуть підключатись до сервера
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    // конструктор
    public Server() {
        // сокет клієнта - поток, що підключатиметься до сервера по адресі(хосту) та порту
        Socket clientSocket = null;

        // серверний сокет
        ServerSocket serverSocket = null;

        try {
            // створення серверного сокета по визначеному порту
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущено!");

            // запуск нескінченного циклу - очікуватиме підключення клієнта
            while (true){
                // --- очікування підключень від сервера
                clientSocket = serverSocket.accept();

                // створення обробника для клієнта, що підключиться до сервера (у параметрах this - наш сервер)
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);

                // кожне підключення клієнта обробляється у новому потоці
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // процедура закриття (припинення роботи) сервера
                clientSocket.close();
                System.out.println("Сервер зупинено");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // відправлення повідомлення усім клієнтам
    public void sendMessageToOllClients(String message) {
        for (ClientHandler client : clients) {
            client.sendMsg(message);
        }
    }

    // видалення клієнта з колекції при виході з чату
    public void removeClient(ClientHandler client){
        clients.remove(client);
    }

}
