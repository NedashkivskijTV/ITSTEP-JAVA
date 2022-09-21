package edu.itstep.cw20220914.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Artur", 20));
        users.add(new User("Ivan", 27));
        users.add(new User("Petro", 18));
        users.add(new User("Semen", 22));
        users.add(new User("Anton", 21));
        users.add(new User("Андрій", 25));
        users.add(new User("Іван", 27));

        for (User user : users) {
            System.out.println(user);
        }

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (User user : users) {
            System.out.println(user);
        }


    }
}
