package edu.itstep.cw20220926.thread05;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());

        int count = 0;
        while (count >= 0 && !isInterrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

                interrupt();
                //break;
            }
            count++;
            System.out.println(count);
        }

        System.out.println("end " + Thread.currentThread().getName());
    }
}
