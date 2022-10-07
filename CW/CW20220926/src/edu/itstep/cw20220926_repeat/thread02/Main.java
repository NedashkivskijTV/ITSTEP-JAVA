package edu.itstep.cw20220926_repeat.thread02;

public class Main {
    public static void main(String[] args) {
        // встановлення імені потока Thread.currentThread().setName("newName");
        Thread.currentThread().setName("MAIN !!!");

        //System.out.println("start main");

        // виведення інформації про потік через метод .currentThread().getName()
        // Thread.currentThread() - отримання посилання на поточний потік (у якому викликається)
        // getName() - отримання імені потоку
        // за замовчуванням ім'я головного потоку main, імя нового потоку Thread-0
        // наступний потік Thread-1 ...
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread myThread = new MyThread();
        //myThread.run(); // ПОМИЛКА - при виклику методу напряму - робота в один потік
        Thread thread = new Thread(myThread); // запуск через посилання на екземпляр класу
        // передається що буде робити екземпляр класу Thread
        //thread.start();

        // запуск потоку в один рядок - втрачається посилання на поток - неможливо
        // зупинити, отримати дані про потік... Використовується рідко - для простих
        // незалежних автономних потоків, що виконують прості/не важливі процеси
        //new Thread(new MyThread()).start();

        // другим параметром конструктора потоку може вказуватись імя потока
        new Thread(new MyThread(), "NEW THREAD").start();

        //System.out.println("finish main");
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
