package edu.itstep.cw20220921repeat2;

import java.util.Set;
import java.util.TreeSet;

public class Main06 {
    public static void main(String[] args) {

        /** TreeSet - зберігає унікальні значення у сортованому вигляді */
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(13);
        set.add(13);
        set.add(5);
        set.add(26);
        set.add(69);
        set.add(38);

        /** Set - використовується при необхідності збереження унікальних елементів
         * у сортованому порядку */
        System.out.println(set); // [3, 5, 13, 26, 38, 69]

        /** Використання ітератора дає змогу перебрати колекцію у циклі */
        for (Integer integer : set) {
            System.out.print(integer + " "); // 3 5 13 26 38 69
        }
        System.out.println();

    }

}

