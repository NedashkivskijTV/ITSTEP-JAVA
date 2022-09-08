package edu.itstep.cw20220905;

public class Main1 {
    public static void main(String[] args) {
        // рядки - String
        // ссилочний тип даних, що поводиться, як примітив
        // рядки НЕ змінні !!!

        String a = new String("one"); // створення через виділення прамяті - через конструктор String
        String b = new String("one"); // кожен раз при використанні new створюється новий обєкт з новою адресою
        System.out.println(a);
        System.out.println(b);

        System.out.println(a == b); // false - оператор == порівнює ссилки
        System.out.println(a.equals(b)); // true - порівнюється за значенням символів


        System.out.println("-----------------------------------------");
        // створення рядків через stringPool
        String a1 = "one";  // у разі, якщо змінні посилаються на один обєкт
                            // (аналізується вміст рядка) - виниотримують одне посилання
                            // при створенні рядка виділяється спеціальна частина памяті
                            // у Heap (кучі) - stringPool, де зберігатимутся усі рядки
        String b1 = "one";
        System.out.println(a1 == b1); //true - оператор == порівнює ссилки
        System.out.println(a1.equals(b1)); //true

        b1 = "two";
        System.out.println(a1 == b1);// false
        System.out.println(a1.equals(b1));// false

        b1 = "one";
        System.out.println(a1 == b1);//true
        System.out.println(a1.equals(b1));//true

    }
}
