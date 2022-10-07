package edu.itstep.cw20220921_analysis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        List<String> numbersString = new LinkedList<>();
        numbersString.add("one");
        numbersString.add("two");
        numbersString.add("three");
        numbersString.add("three");

        numbersString.forEach(System.out::println);

        System.out.println(numbersString.get(1));
        System.out.println(numbersString.size());
        System.out.println(numbersString.remove(2));

        numbersString.forEach(System.out::println);

        // тест швидкості
        List<Integer> numbersString1 = new ArrayList<>();
        List<Integer> numbersString2 = new LinkedList<>();

        speed(numbersString1); // 28466
        speed(numbersString2); // 75

    }

    public static void speed(List<Integer> list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500_000; i++) {
            list.add(0, i);

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
