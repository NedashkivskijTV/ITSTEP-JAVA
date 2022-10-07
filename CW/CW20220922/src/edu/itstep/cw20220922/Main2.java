package edu.itstep.cw20220922;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main2 {
    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter("./test1.txt");
            printWriter.write("Привет\n");
            printWriter.write("Мир!\n");
            printWriter.println("Hello");
            printWriter.println("World!");
            printWriter.flush(); // чистить буфер - дані передаються з буфера у файл, попередні методи передають дані у буфер

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
