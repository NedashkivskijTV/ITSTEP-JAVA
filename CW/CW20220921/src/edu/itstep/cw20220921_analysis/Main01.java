package edu.itstep.cw20220921_analysis;

import java.util.ArrayList;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        List<String> numbersString = new ArrayList<>();
        numbersString.add("one");
        numbersString.add("two");
        numbersString.add("three");
        numbersString.add("three");

        numbersString.forEach(System.out::println);

        System.out.println(numbersString.get(1));
        System.out.println(numbersString.size());
        System.out.println(numbersString.remove(2));

        numbersString.forEach(System.out::println);
    }
}
