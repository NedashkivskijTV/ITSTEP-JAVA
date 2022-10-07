package edu.itstep.cw20220926_repeat.thread01;

public class Main {
    public static void main(String[] args) {
        System.out.println("start main");

        MyThread myThread = new MyThread(); // створення нового потоку
        //myThread.run(); // ПОМИЛКА - при виклику методу напряму - робота в один потік
        myThread.start(); // запуск нового потоку (native - метод функціонал якого написаний на іншій мові)
                          // (команда для JVM, яка в свою чергу запустить метод run())

        System.out.println("finish main");
    }
}
