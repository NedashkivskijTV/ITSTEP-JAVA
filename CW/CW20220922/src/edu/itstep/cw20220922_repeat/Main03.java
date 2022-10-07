package edu.itstep.cw20220922_repeat;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main03 {
    public static void main(String[] args) {
        // Для запису тексту краще одразу звернутись до об'єктів, котрі працюють з текстом - Writer
        // Використання класу PrintWriter повертає помилку FileNotFoundException, але під час роботи
        // він підключається до файлу, а у разі його відсутності пробує його створити
        // потребує обгорання (по Alt + Enter) у блок try/catch (Surround with try/catch),
        // або передачі помилки на вищий рівень (Add exception to method signature)
        // працює з кириличними символами !!!
        try {
            PrintWriter printWriter = new PrintWriter("./cwrepeat_files/test1.txt"); // приймає рядок - назву файлу, з яким працюватиме
                                                                                             // намагається підключитись до файлу, флщо той є - абстрактна сутність PrintWriter
                                                                                             // підключиться до нього та працюватиме, якщо немає - спробує створити та підключитись
            printWriter.write("Привіт "); // метод write() записує переданий текст у файл, працює з кириличними символами
            printWriter.println("Світе!"); // метод println() записує переданий текст у файл,
                                           // працює з кириличними символами, переносить каретку на наступний рядок
            printWriter.write("Hello\n");
            printWriter.write("World!");
            printWriter.flush(); // flush() - метод, що переносить підготовлений для запису текст з буфера у файл
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
