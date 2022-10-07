package edu.itstep.cw20220926.thread02;


public class Main {
    public static void main(String[] args) {
        //System.out.println("start main");
        Thread.currentThread().setName("MAIN!!!");
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread myThread = new MyThread();
        //myThread.run();
        Thread thread = new Thread(myThread);
        thread.setDaemon(true);
        thread.setPriority(2); // 1-10 - пріоритет
        //thread.join();
        thread.start();

        //new Thread(new MyThread(), "NEW THREAD !!!").start(); // запис у один рядок - відсутнє посилання на потік !!!

        //System.out.println("finish main");
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
