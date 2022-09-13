package edu.itstep.cw20220909.statics;

public class User {
    public String firstName;
    private String lastName;
    public static int count = 0;// публічний модифікатор доступу дає змогу встановлювати
                                // необхідне (початкове) значення вручну
    private static int countPrivate = 0;
    private int id;
    private int idStatic;

    public User() {
        ++count;
        this.id = count;
        this.idStatic = ++countPrivate;
    }

    public int getId() {
        return id;
    }

    public static int getCountPrivate() { // статичний метод - має доступ лише до статичних змінних
        System.out.println(count);//доступ дозволено - статична змінна
        //System.out.println(id);//доступ заборонено
        return countPrivate;
    }
}
