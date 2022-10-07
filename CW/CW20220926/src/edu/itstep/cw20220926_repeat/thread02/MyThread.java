package edu.itstep.cw20220926_repeat.thread02;

public class MyThread implements Runnable{
    @Override
    public void run() {
        //System.out.println("start new thread");
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
