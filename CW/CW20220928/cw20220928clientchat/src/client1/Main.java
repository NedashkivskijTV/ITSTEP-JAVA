package client1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 55555); // підключились до сервера

            new Thread(new ListenThread(socket)).start(); // запуск нового потоку для простуховування повідомлень -
            // слухаємо повідомлення від сервера
            // - посилання на потік не зберігалось оскільки його зупинка за ініціативою користувача не планується
            // - потік сам зупинятиметься по умові у циклі методу run - коли зникне наступний рядок
            // для зчитування - після закриття з'єднання

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream()); // для відправки повідомлень на сервер

            // головний потік - відправляє інф на сервер
            Scanner scannerConsole = new Scanner(System.in); // для отримання повідомлень з консолі
            while (true){
                String message = scannerConsole.nextLine(); // читання повідомлень з консолі
                printWriter.println(message);
                printWriter.flush(); // очищення буфера
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // - Socket socket = new Socket - підключення до сервера
    // - new Thread(new ListenThread(socket)).start(); - запуск нового потоку, щоб він слухавповідомлення з сервера
    //      - при створенні нового потоку до нього передали socket, щоб створити сканер scannerNetwork
    //      за допомогою якого відбуватиметься зчитування
    //      - зчитуванням та роздруком повідомленьу консоль займається метод run() у циклі while
    // - при цьому головний потік
    // - створює printWriter для записування та відправлення повідомлень на сервер
    // - створює scannerConsole для отримання повідомлень з консолі
    // - у циклі while (true){ відбувається зчитування повідомлень, запис у змінну, відправка (очищення буфера)

}
