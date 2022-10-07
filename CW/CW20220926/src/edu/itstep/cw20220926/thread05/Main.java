package edu.itstep.cw20220926.thread05;

public class Main {
    public static void main(String[] args) {

/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //myThread.stop();
        myThread.interrupt();


    }
}
