package edu.itstep.cw20220922_repeat.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("./img.png");
            FileOutputStream fileOutputStream = new FileOutputStream ("./copy/img_copy.png");
            int b = -1;
            while ((b = fileInputStream.read()) != -1){
                fileOutputStream.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
