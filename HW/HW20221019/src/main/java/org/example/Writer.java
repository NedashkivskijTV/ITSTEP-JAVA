package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
    public static void writeText(String string){
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("./log_files/loggingMethods.txt", true));
            printWriter.println(string);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
