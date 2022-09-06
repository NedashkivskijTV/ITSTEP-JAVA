package edu.itstep.cw20220905;

public class Main1 {
    public static void main(String[] args) {
        // рядки - String
        String a = new String("one"); // створення через виділення прамяті
        String b = new String("one");
        System.out.println(a);
        System.out.println(b);

        System.out.println(a == b); // false - порівнює ссилки
        System.out.println(a.equals(b)); // true - порівнюється за значенням символів


        System.out.println("-----------------------------------------");
        // створення рядків через stringPool
        String a1 = "one";
        String b1 = "one";
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));

        b1 = "two";
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));

        b1 = "one";
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));


    }
}
