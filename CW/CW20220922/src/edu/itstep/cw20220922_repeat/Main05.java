package edu.itstep.cw20220922_repeat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main05 {
    public static void main(String[] args) {
        // Використання класу FileOutputStream :
        // - дозволяє записувати дані побайтово
        // - не працює з кириличними символами
        // - перед записом рядка його потрібно поревести у масив типу byte[]
        // повертає помилку FileNotFoundException, IOException
        // потребує обгорання (по Alt + Enter) у блок try/catch (Surround with try/catch),
        // або передачі помилки на вищий рівень (Add exception to method signature)

        String text = "Привітулі, нероби !!!";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream ("./cwrepeat_files/test_byte.txt");

            byte[] buffer = text.getBytes(); // перевод рядка у байти

            fileOutputStream.write(buffer, 0, buffer.length); // приймає масив байтів, 0 - елемент з якого потрібно почати запис, кількість елементів для запису
            System.out.println("The file has been written");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
