package edu.itstep.cw20220926_repeat.thread03;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });
        thread.start(); // запуск потоку
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
