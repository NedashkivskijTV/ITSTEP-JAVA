package edu.itstep.cw20220907;

import java.util.ArrayList;

public class Main03 {
    public static void main(String[] args) {

        /** Примітиви та обгортки */
        int i1 = 1; // примітив
        Integer i2 = 2; // обгортка

        char c1 = '*'; // примітив
        Character c2 = '*'; // обгортка

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4); // true

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6); // false

        System.out.println(i5.equals(i6)); // true

        // Приклад застосування обгортки Integer
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(127);
        //arrayList.add("127"); // неприпустима дія
    }
}
