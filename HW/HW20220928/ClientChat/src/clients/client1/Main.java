package clients.client1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String userName = setUserName("User"); // введення імені користувача та збереження у змінній

            Socket socket = new Socket("localhost", 55555);
            new Thread(new ListenThread(socket)).start();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            Scanner scannerConsole = new Scanner(System.in);

            while(true){
                String message = scannerConsole.nextLine();
                printWriter.println(userName + ": " + message); // включення до вихідних повідомлень інформації про користувача
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String setUserName(String nameDefault){ // метод - ввод імені користувача
        String nameTemp;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username or press Enter to use the default name (User) - ");
        nameTemp = scanner.nextLine();
        if(nameTemp.equals("")){
            return nameDefault;
        }
        return nameTemp;
    }

}
