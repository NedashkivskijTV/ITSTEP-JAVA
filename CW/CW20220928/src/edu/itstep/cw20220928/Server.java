package edu.itstep.cw20220928;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server");
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();

        try {
            ServerSocket serverSocket = new ServerSocket(55555);
            System.out.println("server created");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            Scanner scanner = new Scanner(socket.getInputStream());
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server finish");
    }
}
