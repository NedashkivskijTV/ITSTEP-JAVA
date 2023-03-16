package edu.itstep.cw20220921repeat2;

import java.util.*;

public class Main08_3 {
    public static void main(String[] args) {

        /** TreeMap - упорядкована колекція пар КЛЮЧ-ЗНАЧЕННЯ,
         * - колекція сортується по ключах (алгоритм сортування може налаштовуватись)
         * - ключ унікальний, значення може повторюватись */
        Map<Integer, String> numbers = new TreeMap<>();
        numbers.put(13, "one");
        numbers.put(2, "two");
        numbers.put(57, "three");
        numbers.put(31, "one");

        // Отримання значення по ключу
        System.out.println(numbers.get(2));

        // Перевірка на наявність колекції конкретного ключа
        System.out.println(numbers.containsKey(77)); // false

        // Перевірка на наявність у колекції конкретного значення
        System.out.println(numbers.containsValue("two")); // true

        // Отримання значення по ключу, а у разі відсутності ключа - дефолтного значення
        System.out.println(numbers.getOrDefault(7, "seven")); // seven

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
