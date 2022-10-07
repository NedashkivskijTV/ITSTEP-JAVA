package edu.itstep.cw20220922_repeat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        // Scanner - обгортка (паттерн Декоратор),
        // що знаходеться наверху ієрархії та імплементує інтерфейси Ітератор...
        // застосування даної конструкції дозволяє коректно відобразити кирилічні символи
        try {
            Scanner scanner = new Scanner(new FileInputStream("./cwrepeat_files/test.txt")); //
            //scanner.nextLine(); // метод nextLine() повертає наступний рядок
            //System.out.println(scanner.nextLine()); // читає символи до кінця 1 рядка
            //System.out.println(scanner.nextLine()); // читає символи до кінця 1 рядка
            //System.out.println(scanner.nextLine()); // читає символи до кінця 1 рядка
            //System.out.println(scanner.nextLine()); // застосування методи при відсутності рядка викличе помилку NoSuchElementException !!!
            // Для зчитування застосовуєтьсяметод, що вказує чи є у файлі наступний рядок
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
