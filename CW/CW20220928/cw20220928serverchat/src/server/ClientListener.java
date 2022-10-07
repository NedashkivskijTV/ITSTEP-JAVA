package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientListener implements Runnable{
    private Socket socket;
    private Scanner scannerNetwork;
    private PrintWriter printWriter;
    private Server server; // посилання на сервер

    public ClientListener(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;

        // Ctrl + Alt + t – меню обгортання фрагменту коду у блок
        try {
            scannerNetwork = new Scanner(socket.getInputStream());
            printWriter =  new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (scannerNetwork.hasNextLine()){
            String message = scannerNetwork.nextLine();
            System.out.println(message);
            // відправка отриманого повідомлення усім клієнтам
            server.sendMessageToAll(message); // виклик метода, що відправить повідомлення усім клієнтам
        }
    }

    // метод для відправки щойноотриманого повідомлення усім клієнтам, що підключені
    // даний метод відправляє повідомлення клієнту, при реєстрації якого був даний клас
    public void sendMessage(String message){
        printWriter.println(message);
        printWriter.flush();
    }

}
