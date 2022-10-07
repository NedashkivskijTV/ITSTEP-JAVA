package edu.itstep.cw20220926_repeat.thread05;

public class MyThread2 implements Runnable{
    private boolean interrupted = false;

    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());

        int count = 0;
        //while(count >= 0){
        while(count >= 0 && !this.interrupted){
            count++;
            System.out.println(count);
        }

        System.out.println("end " + Thread.currentThread().getName());
    }

    public void setInterrupted(){
        this.interrupted = true;
    }
}
