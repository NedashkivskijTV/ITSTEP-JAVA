package edu.itstep.cw20220928_repeat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server started");
        //Scanner scanner = new Scanner(System.in); //створення процесу (в ньому може бути декілька потоків)
        //scanner.nextLine();

        try {
            ServerSocket serverSocket = new ServerSocket(55555); // об'єкт, який створює сервер для сокета - створюється
                                                            // програма до якої можна буде під'єднатись,
                                                            // тобто отримати дані чи відправити дані по мережі
                                                            // створює виключну ситуацію,
                                                            // може приймати номер порта
            System.out.println("Server created");

            Socket socket = serverSocket.accept(); // команда на приймання даних від когось,
                                                    // створює об'єкта класа Socket (розетка)
                                                    // Socket socket - посилання на об'єкт
            System.out.println("Client connected");

            Scanner scanner = new Scanner(socket.getInputStream());
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server finished");
    }
}
