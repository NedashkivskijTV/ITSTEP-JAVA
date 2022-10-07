package edu.itstep.cw20220922_repeat;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main04 {
    public static void main(String[] args) {
        try {
            // Використання класу FileWriter:
            // дозволяє додавата дані у файл
            // працює з кириличними символами !!!
            // повертає помилку IOException -
            // потребує обгорання (по Alt + Enter) у блок try/catch (Surround with try/catch),
            // або передачі помилки на вищий рівень (Add exception to method signature)

            PrintWriter printWriter = new PrintWriter(new FileWriter("./cwrepeat_files/test1.txt", true)); // приймає рядок - назву файлу, з яким працюватиме
            // та true/false(за замовчуванням) - вказує на необхідність додавання/перезаписування даних у файлі
            // намагається підключитись до файлу, якщо той є - абстрактна сутність PrintWriter
            // підключиться до нього та працюватиме, якщо немає - спробує створити та підключитись
            printWriter.write("Привіт "); // метод write() записує переданий текст у файл, працює з кириличними символами
            printWriter.println("Світе!"); // метод println() записує переданий текст у файл,
            // працює з кириличними символами, переносить каретку на наступний рядок
            printWriter.write("Hello\n");
            printWriter.write("World!");
            printWriter.flush(); // flush() - метод, що переносить підготовлений для запису текст з буфера у файл
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
