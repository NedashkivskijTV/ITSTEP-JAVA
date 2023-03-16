package edu.itstep.cw20220921repeat2;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main05 {
    public static void main(String[] args) {

        /** LinkedHashSet - зберігає унікальні значення у порядку додавання у колекцію */
        Set<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(13);
        set.add(13);
        set.add(5);
        set.add(26);
        set.add(69);
        set.add(38);

        /** Set - використовується при необхідності збереження унікальних елементів
         * Порядок збереження об'єктів відповідає порчядку їх додавання */
        System.out.println(set); // [3, 13, 5, 26, 69, 38]

        /** Використання ітератора дає змогу перебрати колекцію у циклі */
        for (Integer integer : set) {
            System.out.print(integer + " "); // 3 13 5 26 69 38
        }

    }
}
