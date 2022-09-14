package edu.itstep.hw20220905;

public class Main {
    public static void main(String[] args) {
        testUser();
        //testAverageAge();
    }

    public static void testAverageAge(){
        ArrayListUser listUsers = new ArrayListUser();
        //listUsers.printArr();
        //System.out.println(listUsers.size());
        listUsers.addFirst(new User("Petro", "Petrenko", 18));
        listUsers.addFirst(new User());
        listUsers.addFirst(new User("Taras", "Shevchenko", 20));
        listUsers.addFirst(new User("Ivan", "Franko", 31));
        listUsers.addFirst(new User("Ivan", "Kotliarevskiy", 27));
        listUsers.addFirst(new User());
        listUsers.addFirst(new User("Marko", "Vovchok", 25));
        listUsers.addFirst(new User("Panas", "Mirniy", 30));
        listUsers.printArr();

        // визначення середнього віку серед екземплярів User у масиві
        int ollUsersAge = 0;
        double averageAge = 0.0;
        for (int i = 0; i < listUsers.size(); i++) {
            ollUsersAge += listUsers.get(i).age;
        }
        averageAge = 1.0 * ollUsersAge / listUsers.size();
        System.out.println("--------------------------------------------------");
        System.out.print("Users average age = ");
        System.out.println(averageAge);
    }

    public static void testUser(){
        User user01 = new User();
        //user01.PrintUser();
        //System.out.println("--------------------------------------------------");
        User user02 = new User("Petro", "Petrenko", 18);
        //user02.PrintUser();
        //System.out.println("--------------------------------------------------");
        User user03 = new User("Taras", "Shevchenko", 20);
        //user03.PrintUser();
        //System.out.println("--------------------------------------------------");
        User user04 = new User("Ivan", "Franko", 31);
        //user04.PrintUser();
        //System.out.println("--------------------------------------------------");
        User user05 = new User("Ivan", "Kotliarevskiy", 27);
        User user06 = new User("Marko", "Vovchok", 25);
        User user07 = new User("Panas", "Mirniy", 30);
        //user05.PrintUser();
        System.out.println("--------------------------------------------------");

        ArrayListUser listUsers = new ArrayListUser();
        listUsers.printArr();
        System.out.println(listUsers.size());
        User temp = listUsers.get(7);
        //temp.PrintUser(); !!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(temp == null? "temp is null": "NOT null");
        temp = listUsers.getFirst();
        System.out.println(temp == null? "temp is null": "NOT null");
        temp = listUsers.getLast();
        System.out.println(temp == null? "temp is null": "NOT null");
        listUsers.addLast(new User("name", "surname", 18));
        listUsers.set(0, new User("---", "---", 77));

        listUsers.printArr();
        listUsers.delete(0);
        listUsers.printArr();

        //listUsers.size() = 0 !!!!!
        System.out.println("-------------------+++-------------------------------");
        //System.out.println(listUsers.size());
        listUsers.addFirst(user02);
        listUsers.addFirst(user01);
        listUsers.addFirst(user03);
        listUsers.addFirst(user04);
        listUsers.addFirst(user05);
        listUsers.addFirst(user06);
        listUsers.addFirst(user07);
        listUsers.printArr();

        //тестування методів
        /*System.out.println(listUsers.size());
        System.out.println("--------------------------------------------------");
        listUsers.addLast(user05);
        listUsers.printArr();
        System.out.println("--------------------------------------------------");*/

        //User userTest = listUsers.get(3);
        /*userTest.PrintUser();
        listUsers.addLast(userTest);
        listUsers.printArr();
        System.out.println("--------------------------------------------------");

        userTest = listUsers.getFirst();
        userTest.PrintUser();
        System.out.println("--------------------------------------------------");
        userTest = listUsers.getLast();
        userTest.PrintUser();
        System.out.println("--------------------------------------------------");

        listUsers.set(0, user06);
        listUsers.set(3, user06);
        listUsers.printArr();
        System.out.println("--------------------------------------------------");

        System.out.println(listUsers.size());
        listUsers.delete(0);
        listUsers.delete(3);
        listUsers.delete(1);
        listUsers.addLast(user07);
        listUsers.printArr();
        System.out.println(listUsers.size());*/
        System.out.println("--------------------------------------------------");
    }
}
