package edu.itstep.cw20220928_repeat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client started");
//        Scanner scanner = new Scanner(System.in); //створення процесу (в ньому може бути декілька потоків)
//        scanner.nextLine();

        try {
            Socket socket = new Socket("localhost", 55555); // створення обєкта, який допоможе
                                                                      // створити зєднання на стороні клієнта
                                                                      // приймає назву хоста (localhost або 127.0.0.1),
                                                                        // порт (555555 - визначений у налаштуваннях сервера)
                                                                        // створення даного обєкта вказує на те, що клієнт до сервера підключений вдало
            System.out.println("Connect to Server");
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Hello from client");
            printWriter.flush(); // очищення буфера
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client finished");
    }
}
