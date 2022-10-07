package edu.itstep.cw20220921;

import java.util.*;

public class Main8 {
    public static void main(String[] args) {
        Map<Integer, String> numbers = new TreeMap<>();
        numbers.put(13, "one");
        numbers.put(2, "two");
        numbers.put(57, "three");
        numbers.put(17, "one");

        System.out.println(numbers.get(13));

        Set<Integer> keys = numbers.keySet();
        System.out.println(keys);

        Collection<String> values = numbers.values();
        System.out.println(values);

        for (Map.Entry<Integer, String> pair : numbers.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
