package edu.itstep.cw20220926_repeat.thread02;

public class Main1 {
    public static void main(String[] args) {
        Thread.currentThread().setName("MAIN !!!"); // встановлення імені потока
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread); // запуск через посилання на екземпляр класу
        // передається що буде робити екземпляр класу Thread
        thread.setDaemon(true); // оголошення потоку демоном - має закінчити роботу разом з головним потоком
        // встановлення пріоритету через setPriority(1) (1 - 10б за замовчуванням main - 5)
        // використовується рідко, оскільки робота JVM з приоритетами малопередбачувана
        thread.setPriority(1);
        thread.start(); // запуск потоку

        try { // емуляція роботи головкого потоку
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " end");
   }
}
