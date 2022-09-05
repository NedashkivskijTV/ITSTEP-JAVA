package edu.itstep.firstproject;

public class Main2 {
    public static void main(String[] args) {
        // преобразование типов - з меншого типу в більший - без втрати даних
        // byte -> short -> int -> long
        //явне, неявне
        byte b = 127;
        int i = b;
        System.out.println(i);

        int i1 = 127;
        int i2 = 128;
        // byte b1 = i1; // - попередження інтелліДж про спробу некоректної дії
        byte b1 = (byte) i1; // явне перетворення
        byte b2 = (byte) i2; // явне перетворення
        System.out.println(b1);
        System.out.println(b2);

        char ch1 = 'a';
        char ch2 = 'b';
        System.out.println(ch1);
        System.out.println((int) ch1); // код символа в таблиці Unicode
        System.out.println((int) ch2); // код символа в таблиці Unicode
        System.out.println((int) ch1 - (int) ch2); // код символа в таблиці Unicode

    }
}
