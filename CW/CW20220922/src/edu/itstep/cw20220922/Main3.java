package edu.itstep.cw20220922;

import java.io.*;

public class Main3 {
    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("./test1.txt", true));
            printWriter.write("Привет\n");
            printWriter.write("Мир!\n");
            printWriter.println("Hello");
            printWriter.println("World!");
            printWriter.println("\n");
            printWriter.flush(); // чистить буфер - дані передаються з буфера у файл, попередні методи передають дані у буфер

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
