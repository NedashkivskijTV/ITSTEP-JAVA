package edu.itstep.cw20220921;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>();
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 500_000; i++) {
//            integers.add(0, i);
//
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start); // 29017
        List<Integer> integers = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500_000; i++) {
            integers.add(0, i);

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start); // 62



    }
}
