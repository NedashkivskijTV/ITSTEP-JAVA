package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ClientListener> clientListeners = new ArrayList<>();

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(55555); // створення сервера
            System.out.println("Server created");

            while (true) {
                Socket socket = serverSocket.accept(); // очікування клієнта - після його появи ...
                System.out.println("Client connected " + socket.getPort());

                // створення другорядного потоку для кожного клієнта, що підключається
                // new Thread(new ClientListener(socket)).start(); // даний рядок не підходить при потребі
                // збереження інф про створені потоки у колекції clientListeners

                ClientListener clientListener = new ClientListener(socket, this); // створення обєкта clientListener,
                // який буде спілкуватись кожен зі своїм клієнтом - буде створювати та передавати повідомлення,
                // приймає socket для забезпечення можливості спілкування з клієнтом та посилання на сам об'єкт,
                // що його створив (server) - для отримання інф про усіх клієнтів та їх сповіщення про отриману інф

                new Thread(clientListener).start();

                clientListeners.add(clientListener);

                // отримання повідомлення
                // відправка повідомлення
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для відправки повідомлення усім підключеним клієнтам
    // - sendMessageToAll буде приймати повідомлення від clientListener
    // clientListener сповістить сервер про итримання повідомлення та необхідність його направлення усім клієнтам
    // сервер, отримавши повідомлення пробігає по колекції clientListener та у кожного клієнта викликає метод sendMessage(message)
    public void sendMessageToAll(String message) {
        clientListeners.forEach(clientListener -> clientListener.sendMessage(message));
    }

}
