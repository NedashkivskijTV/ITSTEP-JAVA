package edu.itstep.hw20220919_analysis.exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main1 {
    public static void main(String[] args) {
        // checked - потребує застосування блоку try ... catch

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("=======================================================================");
        try {
            PrintWriter printWriter = new PrintWriter("./text.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
