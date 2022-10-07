package client3;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ListenThread implements Runnable{
    private Socket socket;
    private Scanner scannerNetwork; // проініціалізувати можна лише після отримання socket - у конструкторі

    public ListenThread(Socket socket) {
        this.socket = socket;
        try {
            scannerNetwork = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (scannerNetwork.hasNextLine()){
            System.out.println(scannerNetwork.nextLine());
        }
    }

    // Призначення класу - зчитувати інформацію на боці клієнта від сервера

    //На даний момент у проекті є потік ListenThread, який під час створення отримує socket
    // (socket – потрібен щоб отримати поток для зчитування інф по мережі), зчитування
    // відбуватиметься доти, доки виконується умова у циклі while(true) – надалі буде змінено
    // на виклик метода scannerNetwork.hasNextLine() у сканера – цей метод очікуватиме новий
    // рядок доти, доки є з’єднання – після його розриву метод hasNextLine() поверне false та цикл зупиниться
}
