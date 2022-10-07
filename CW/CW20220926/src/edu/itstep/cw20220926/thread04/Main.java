package edu.itstep.cw20220926.thread04;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");

        Thread thread = new Thread(Main::work);
        thread.start();

        System.out.println(Thread.currentThread().getName() + " end");
    }

    public static void work() {
        System.out.println(Thread.currentThread().getName() + " start");

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("end new thread");
        System.out.println(Thread.currentThread().getName() + " end");

    }
}
