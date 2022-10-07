package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 55555);

            new Thread(new ListenThread(socket)).start(); // слухає повідомлення від сервера

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scannerConsole = new Scanner(System.in);
            while (true){
                String message = scannerConsole.nextLine();
                printWriter.println(message);
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
