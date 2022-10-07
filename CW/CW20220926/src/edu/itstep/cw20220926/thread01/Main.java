package edu.itstep.cw20220926.thread01;

public class Main {
    public static void main(String[] args) {
        System.out.println("start main");

        MyThread myThread = new MyThread();
        //myThread.run();
        myThread.start();

        System.out.println("finish main");
    }
}
