package edu.itstep.cw20220914_analysis.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // сортування колекції простих об'єктів відбувається
        // автоматично, із застосуванням вбудованих методів (алгоритмів)
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(100);
        integers.add(15);
        integers.add(8);
        integers.add(6);
        integers.add(54);
        integers.add(77);
        integers.add(12);
        integers.add(88);
        System.out.println(integers);
        Collections.sort(integers); // сортування колекції (швидке сортування)
        System.out.println(integers);
        System.out.println("----------------------------------------------------------");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Artur");
        strings.add("Petro");
        strings.add("bobb");
        strings.add("Artemij");
        strings.add("bob");
        strings.add("Ivan");
        strings.add("Artemij");
        strings.add("Artem");
        strings.add("Bob");
        System.out.println(strings);
        Collections.sort(strings);
        System.out.println(strings);

        System.out.println("----------------------------------------------------------");
        // сортування складних об'єктів потребує вживання додаткових
        // заходів - імплементація у класі інтерфейсу Comparable (типізований)
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Stepan", 30));
        users.add(new User("Ivan", 19));
        users.add(new User("Petro", 18));
        users.add(new User("13Ivan", 19));
        users.add(new User("Artur", 27));
        users.add(new User("Anton", 30));
        users.add(new User("Artem", 33));
        users.add(new User("Artem", 31));

        //System.out.println(users);
        printUser(users);
        System.out.println();
        Collections.sort(users);
        printUser(users);
    }
    public static void printUser(ArrayList<User> arr){
        for (User user : arr) {
            System.out.println(user);
        }
    }
}
