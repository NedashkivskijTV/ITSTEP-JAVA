package edu.itstep.cw20220928;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client");
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();

        try {
            Socket socket = new Socket("localhost", 55555);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Hello from client !");
            printWriter.flush();

            System.out.println("Connect to server");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client finish");
    }
}
