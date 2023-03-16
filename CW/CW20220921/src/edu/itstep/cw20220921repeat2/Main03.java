package edu.itstep.cw20220921repeat2;

import java.util.HashSet;
import java.util.Set;

public class Main03 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(13);
        set.add(13);
        set.add(5);
        set.add(26);
        set.add(69);
        set.add(38);

        /** Set - використовується при необхідності збереження унікальних елементів
         * Однак порядок збереження об'єктів не колекцією Set гарантується */
        System.out.println(set);

    }
}

