package edu.itstep.cw20220922_repeat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main01 {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("./cwrepeat_files/test.txt");
            int b = -1; // змінна до якої зчитуватиметься побайтово (формат unsigned int) інф з файлу
            while ((b = fileInputStream.read()) != -1){ // метод read() повертає -1 коли немає що читати з потокугенерує помилку (додати catch)
                //System.out.println(b); // побайтовий роздрук інф, зчитаної з файлу
                System.out.print((char) b); // побайтове виведення інф,приведеної до char і в один рядок
                // Дана конструкція не працює з кириличними символами - використовується Unicode таблиця
                // (65 тис символів), які не вміщяються в 1 байт (там на кожен символ використовується по 2 байти)
                // в той же час таблиця ASCII використовує 256 символів, що передаються в 1 байті
                // - для виправлення ситуації використовуються потоки, призначені суто для роботи з текстом (Reader, Writer)
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
