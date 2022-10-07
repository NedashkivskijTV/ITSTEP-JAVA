package edu.itstep.cw20220922.practice;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        // скопіювати вміст графічного файлу у інший файл
        // тобто зробити копію графічного файлу

        // 1 спосіб ----------------------------------------------------------------------------------------------------
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File("./img.png"));
            os = new FileOutputStream(new File("./imgCopy1.png"));

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0){
                os.write(buffer, 0, length);
            }
            System.out.println("Copied 1 !");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // 2 спосіб ----------------------------------------------------------------------------------------------------
        try {
            FileInputStream fileInputStream = new FileInputStream("./img.png");
            FileOutputStream fileOutputStream = new FileOutputStream("./imgCopy2.png");
            int b = -1;
            while ((b = fileInputStream.read()) != -1){
                fileOutputStream.write(b);
            }
            System.out.println("Copied 2 !");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3 спосіб ----------------------------------------------------------------------------------------------------
        try {
            URL imageURL = new URL("file:./img.png");
            BufferedImage bi = ImageIO.read(imageURL);

            ImageIO.write(bi, "jpg", new File("./imgCopy3.png"));
            System.out.println("Copied 3 !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
