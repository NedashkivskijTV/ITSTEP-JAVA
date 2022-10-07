package edu.itstep.hw20220919_analysis.exceptions;

public class Main2 {
    public static void main(String[] args) {

        // unchecked

        System.out.println("start");

        int key = 777;
        if (key == 777) {
            //throw new RuntimeException("Hello world!");
            throw new User();
        }

        System.out.println("finish"); // помилка - Unreachable statement (недоступне оголошення або недоступна область)
    }
}
