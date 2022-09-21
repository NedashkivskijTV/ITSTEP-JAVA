package edu.itstep.cw20220919.exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main1 {
    public static void main(String[] args) {
        // перевіряємі -checked
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            PrintWriter printWriter = new PrintWriter("./text.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
