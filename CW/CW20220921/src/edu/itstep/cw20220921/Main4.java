package edu.itstep.cw20220921;

import java.util.HashSet;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        User user1 = new User("Ivan", "Ivanov");
        User user2 = new User("Ivan", "Ivanov");
        User user3 = new User("Petro", "Petrenko");

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(users);
    }
}
