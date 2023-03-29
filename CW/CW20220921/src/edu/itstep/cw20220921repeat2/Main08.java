package edu.itstep.cw20220921repeat2;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main08 {
    public static void main(String[] args) {

        /** HashMap - неупорядкована колекція пар КЛЮЧ-ЗНАЧЕННЯ
         * - ключ унікальний, значення може повторюватись */
        Map<Integer, String> numbers = new HashMap<>();
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