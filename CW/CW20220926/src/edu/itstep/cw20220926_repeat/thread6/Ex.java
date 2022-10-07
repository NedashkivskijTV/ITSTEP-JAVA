package edu.itstep.cw20220926_repeat.thread6;

public class Ex {
    //private boolean exit = false;
    private volatile boolean exit = false;

    public void start(){
        new Thread(() -> {
            Thread.currentThread().setName("first-thread");
            System.out.println(Thread.currentThread().getName() + " started");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exit = true;
            System.out.println(exit);
            System.out.println(Thread.currentThread().getName() + " finished");

        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("second-thread");
            System.out.println(Thread.currentThread().getName() + " started");
            while(!exit){ // exit = true

            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }).start();
    }

    public static void main(String[] args) {
        Ex ex = new Ex();
        ex.start();
        // після виклику методі ex.start() - він запускає два потоки - коли саме
        // 1 або 2 - вирішує віртуальна машина
        // при запуску даної задачі без використання волотильності отримаємо
        // нескінченний цикл у 2 потоці при коректній роботі 1-го.
        // Причина - перенесення змінної exit до кешу процесора з метою збільшення
        // продуктивності роботи ЦП (дефакто створюється локальна копія)
        // Для захисту від подібних ситуацій використовується ключове слово volatile
        // (перед типом даних змінної), при цьому кешування забороняється
    }
}
