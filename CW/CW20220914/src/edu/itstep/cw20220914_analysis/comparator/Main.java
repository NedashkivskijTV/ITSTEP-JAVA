package edu.itstep.cw20220914_analysis.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Stepan", 30));
        users.add(new User("Ivan", 19));
        users.add(new User("Petro", 18));
        users.add(new User("13Ivan", 19));
        users.add(new User("Artur", 27));
        users.add(new User("Anton", 30));
        users.add(new User("Artem", 33));
        users.add(new User("Artem", 31));
        ArrayList<User> usersAnonymous = new ArrayList<>(users);
        ArrayList<User> usersLambda = new ArrayList<>(users);
        ArrayList<User> usersComparatorComparing = new ArrayList<>(users);
        ArrayList<User> usersComparatorSort = new ArrayList<>(users);

        System.out.println("До сортування");
        printUser(users);
        System.out.println();

        // використання посилання на метод класу, що імплементує
        // інтерфейс Comparator
        System.out.println("Сортування - через виклик екземпляра класу------------------------------");
        Collections.sort(users, new ComparatorUserAge());
        printUser(users);
        System.out.println();

        // інший алгоритм сортування передбачає створення нового класу
        // з іншою реалізацією методу compare
        System.out.println("Сортування у зворотному порядку - через виклик екземпляра класу------------------------------");
        Collections.sort(users, new ComparatorUserAgeDesc());
        printUser(users);
        System.out.println();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        // використання анонімного класу, що реалізує інтерфейс Comparator
        System.out.println("Сортування - використання анонімного класу (по полю Name)------------------------------");
        Collections.sort(usersAnonymous, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printUser(usersAnonymous);
        System.out.println();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        // використання лямбда функції
        System.out.println("Сортування - використання лямбда функції (реверсно по полю Name)------------------------------");
        Collections.sort(usersLambda, (o1, o2) -> o2.getName().compareTo(o1.getName()));
        printUser(usersLambda);
        System.out.println();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        // використання Comparator.comparing
        System.out.println("Сортування - використання Comparator.comparing (по полю Name)------------------------------");
        Collections.sort(usersComparatorComparing, Comparator.comparing(User::getName));
        printUser(usersComparatorComparing);
        System.out.println();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        // використання Comparator.comparing - комбіноване сортування
        System.out.println("Сортування -  Comparator.comparing - комбіноване сортування (по полю Name та Age)------------------------------");
        Collections.sort(usersComparatorSort, Comparator.comparing(User::getName).thenComparing(User::getAge));
        printUser(usersComparatorSort);
        System.out.println();

    }

    public static void printUser(ArrayList<User> arr) {
        for (User user : arr) {
            System.out.println(user);
        }
    }

}
