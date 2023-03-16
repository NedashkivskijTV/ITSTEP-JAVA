package edu.itstep.cw20220921repeat2;

import java.util.LinkedList;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        System.out.println("\n======= LinkedList() ========================================");

        List<String> numbersString = new LinkedList<>(); // створення колекції ArrayList

        System.out.println("\n======= add() ========================================");
        numbersString.add("one"); // додати елемент
        numbersString.add("two"); // додати елемент
        numbersString.add("three"); // додати елемент

        System.out.println("\n======= forEach() ========================================");
        numbersString.forEach(System.out::println); // перебір елементів колекції у циклі forEach

        System.out.println("\n======= List.of() ========================================");
        List<String> stringList = List.of("one", "two", "three", "four"); // створення списку з переліку елементів
        //stringList.forEach(System.out::println); // перебір елементів колекції у циклі forEach
        printList(stringList);

        System.out.println("\n======= addAll() ========================================");
        numbersString.addAll(1, stringList); // вставка елементів колекції до існуючої колекції починаючи з вказаного індекса
        //numbersString.forEach(System.out::println); // перебір елементів колекції у циклі forEach
        printList(numbersString);

        System.out.println("\n======= indexOf() ========================================");
        System.out.println(numbersString.indexOf("three")); // індекс першого входження об'єкта у колекції

        System.out.println("\n======= get() ========================================");
        System.out.println(numbersString.get(1)); // отримати елемент за індексом

        System.out.println("\n======= size() ========================================");
        System.out.println(numbersString.size()); // калькість елементів колекції

        System.out.println("\n======= remove() ========================================");
        System.out.println(numbersString.remove(0)); // видалення елемента за індексом
        System.out.println(numbersString.size()); // кількість елементів колекції
        //numbersString.forEach(System.out::println); // перебір елементів колекції у циклі  forEach
        printList(numbersString);

        System.out.println("\n======= set() ========================================");
        System.out.println(numbersString.set(4, "five")); // заміна елемента по індексу
        System.out.println(numbersString.get(4)); // отримати елемент за індексом

        System.out.println("\n======= subList() ========================================");
        List<String> stringList1 = numbersString.subList(2, 5); // отримання підстроки у межах початкового (входить) та кінцевого (не входить) індекців
        //stringList1.forEach(System.out::println); // перебір елементів колекції у циклі  forEach
        printList(stringList1);

        System.out.println("\n======= sort() ========================================");
        numbersString.sort((el1, el2) -> el2.compareTo(el1)); // сортування з використанням компаратора - використано лямбда-функцію - реверсно
        printList(numbersString);
        System.out.println();
        numbersString.sort(String::compareTo); // сортування - використання вбудованого у тип методу (пропонується як заміна попередньому варіанту) - за зростанням
        //numbersString.forEach(System.out::println); // перебір елементів колекції у циклі  forEach
        printList(numbersString);
    }

    public static void printList(List<String> list){
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
