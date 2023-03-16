package edu.itstep.cw20220921repeat2;

import java.util.*;

public class Main08_2 {
    public static void main(String[] args) {

        /** LinkedHashMap - упорядкована колекція пар КЛЮЧ-ЗНАЧЕННЯ,
         * - зберігає порядок додавання елементів
         * - ключ унікальний, значення може повторюватись */
        Map<Integer, String> numbers = new LinkedHashMap<>();
        numbers.put(13, "one");
        numbers.put(2, "two");
        numbers.put(57, "three");
        numbers.put(31, "one");

        // Отримання значення по ключу
        System.out.println(numbers.get(2));

        // Отримання колекції ключів
        Set<Integer> keys = numbers.keySet(); // виводиться у форматі колекції Set (унікальні значення)
        System.out.println(keys);

        // Отримання колекції значень
        Collection<String> values = numbers.values(); // може бути поміщенимй у будь-яку реалізацію інтерфейса Collection, але колекція Set знищить повторювані значення
        System.out.println(values);

        // Перебирання колекції парами елементів
        for (Map.Entry<Integer, String> integerStringEntry : numbers.entrySet()) {
            System.out.println(integerStringEntry.getKey() + " " + integerStringEntry.getValue());
        }
    }
}
