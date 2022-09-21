package edu.itstep.cw20220919.exceptions;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("start");

        int key = 777;
        if(key == 777){
            throw new RuntimeException("Hello world!");
        }

        System.out.println("end");
    }
}
