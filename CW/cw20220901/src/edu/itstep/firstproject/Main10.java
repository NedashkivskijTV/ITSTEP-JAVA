package edu.itstep.firstproject;

public class Main10 {
    public static void main(String[] args) {
        // оператори унарні бінарні тернарні

        int count = 1;
        count++;
        System.out.println(-count);
        System.out.println(1 - 2);

        int number = 1;
        String result;
        if (number >= 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }

        // тернарка
        String res = (number >= 0) ? "positive": "negative";
        System.out.println(res);

    }
}