package edu.itstep.cw20220914.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
/*        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(100);
        integers.add(8);
        integers.add(6);
        integers.add(15);
        integers.add(12);
        integers.add(88);
        System.out.println(integers);
        //Collections.shuffle(integers);
        Collections.sort(integers);

        System.out.println(integers.toString());


        ArrayList<String> str = new ArrayList<>();
        str.add("Artur");
        str.add("Semen");
        str.add("Ivan");
        str.add("Bob");
        str.add("Alan");
        str.add("Сергій");
        str.add("Артемій");
        str.add("Іванко");
        System.out.println(str);
        Collections.sort(str);
        System.out.println(str);*/

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Artur", 20));
        users.add(new User("Ivan", 27));
        users.add(new User("Petro", 18));
        users.add(new User("Semen", 22));
        users.add(new User("Anton", 21));
        users.add(new User("Андрій", 25));
        users.add(new User("Іван", 30));

        for (User user : users) {
            System.out.println(user);
        }

        Collections.sort(users);
        //Arrays.sort(users);

        System.out.println("---------------------------------");
        for (User user : users) {
            System.out.println(user);
        }


    }
}
