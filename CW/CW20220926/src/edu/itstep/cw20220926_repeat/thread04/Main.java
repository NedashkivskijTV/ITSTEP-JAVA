package edu.itstep.cw20220926_repeat.thread04;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");

        // оголошення нового потоку через посилання на статичний метод work (збігається за сигнатурами з інтерфейсом Runnable)
        Thread thread = new Thread(Main::work);
        thread.start(); // запуск потоку

        System.out.println(Thread.currentThread().getName() + " end");

    }

    public static void work(){
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

    }


}
