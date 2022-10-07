package edu.itstep.cw20220926_repeat.thread05;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());

        int count = 0;
        //while(count >= 0){
        while(count >= 0 && !isInterrupted()){

            try { // емуляція простою паралельного/нового потоку -
                // призводить до виникнення помилки InterruptedException (головний потік звертається до нового для передачі команди на зупинку, новий вже зупинений)
                // після аварійної зупинки головного потоку робота нового потоку продовжується
                // для виправлення потрібно у блоку catch викликати метод interrupt()(більш коректний варіант)
                // або команду break(аварійне завершення - критичний код може не виконатись)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
                //break;
            }
            // важливий код
            count++;
            System.out.println(count);
        }

        System.out.println("end " + Thread.currentThread().getName());
    }
}
