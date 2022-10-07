package edu.itstep.cw20220922_repeat;

import java.io.*;

public class Main08 {
    public static void main(String[] args) {

        // Читання та запис при роботі з масивами байтів - класи ByteArrayInputStream, ByteArrayOutputStream
        // Використвується для : збереження об'єктів у файл, створення глибокої копії об'єкта (але створюється файл)
        // повертає помилку IOException
        // потребує обгорання (по Alt + Enter) у блок try/catch (Surround with try/catch),
        // або передачі помилки на вищий рівень (Add exception to method signature)

        User user = new User("Petro", "Petrenko");

        // запис у файл
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./cwrepeat_files/test_byte_serial.txt"));
            outputStream.writeObject(user); // ObjectOutputStream - здійснює серіалізацію - дані з об'єкта переводить у байтовий вигляд
                                            // при цьому об'єкт має імплементувати інтерфейс Serializable (маркерний інтерфейс)
        } catch (IOException e) {
            e.printStackTrace();
        }

        // читання з файлу
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./cwrepeat_files/test_byte_serial.txt"));
            User newUser = (User) inputStream.readObject(); // отримується Object та приводиться до User
            System.out.println(user.getFirstName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
