package edu.itstep.cw20220926_repeat.thread05;

public class Main {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        try { // режим очікування для головного потока
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //myThread.stop(); // зупинка нового потоку - метод застарілий, але працює
        // аварійна зупинка потоку - застосування даного методу може призвести
        // до втрати критичного функціоналу

        myThread.interrupt(); // перервати метод - змінює "флаг завершення"
        // з false на true
        // при цьому новий потік має отримати команду на перевірку -
        // потребує застосування команди на примусову перевірку "флага" -
        // потребує використання методу isInterrupted() у коді нового потоку -
        // поток сам перевірить потрібне поле та обере момент зупинки
        // При використання даного способу можна забезпечити виконання важливого
        // коду перед завершенняи роботи потоку
        // метод isInterrupted() буде присутній лише при створенні потоку
        // наслідуванням класу Thread,  при реалізації(імплементації) інтерфейсу
        // Runnable потрібно потрібно додати у клас змінну boolean, метод для зміни
        // її значення та перевіряти це значення в коді потоку

    }
}