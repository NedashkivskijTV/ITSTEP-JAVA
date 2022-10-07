package edu.itstep.hw20220921;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        getUsers();

//        - Получить arraylist только с пользователями (экземпляры класса User, не Employee);
        task1();

//        - Получить средний возраст;
        task2();

//        - Получить средний возраст среди несовершеннолетних;
        task3();

//        - Получить средний оклад на отдел;
        task4();

//        - Получить пользователей у которых почта "gmail.com";
        task5();

//        - Получить электронные почты все совершеннолетних женщин,
//                не старше 30 лет, проживающих в Украине, которые являются сотрудниками.
        task6();
    }

    public static void getUsers(){
        List<User> users = DataBase.getUsers();
        System.out.println("Загальний список:");
        users.forEach(System.out::println);
        System.out.println();
    }

    public static void task1(){
        List<User> users = DataBase.getUsers();

        System.out.println();
        System.out.println("Список (ArrayList) користувачів (тільки User) :");
        ArrayList<User> listArrayUsers = users
                .stream()
                .filter(o -> o.getClass().getSimpleName().equals("User"))
                .collect(Collectors.toCollection(ArrayList::new));
        listArrayUsers.forEach(System.out::println);
        System.out.println();
    }

    public static void task2(){
        List<User> users = DataBase.getUsers();

        double averageAge = users
                .stream()
                .mapToInt(u -> u.getAge())
                .summaryStatistics()
                .getAverage();
        System.out.println("Середній вік по БД = " + averageAge);
        System.out.println();
    }

    public static void task3(){
        int controlAge = 18;
        List<User> users = DataBase.getUsers();

        double averageAge = users
                .stream()
                .filter(u -> u.getAge() < controlAge)
                .mapToInt(u -> u.getAge())
                .summaryStatistics()
                .getAverage();
        System.out.println("Середній вік серед неповнолітніх по БД = " + averageAge);
        System.out.println();
    }

    public static void task4(){
        List<User> users = DataBase.getUsers();

        System.out.println("Середня зарплата по відділах :");
        //список обєктів IntSummaryStatistics по відділах
        //IntSummaryStatistics - формується на основі зарплат працівників, містить методи getAverage, getCount, getMax, getMin, getSum...
        Map<Department, IntSummaryStatistics> usersByDepartment = users
                .stream()
                .filter(o -> o.getClass().getSimpleName().equals("Employee"))
                .map(u -> (Employee)u)
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summarizingInt(Employee::getWage)));

        usersByDepartment.forEach((department, sumWage) -> {
            System.out.println(department);
            System.out.println(sumWage.getAverage());
        });
        System.out.println();
    }

    public static void task5(){
        String controlString = "gmail.com";
        List<User> users = DataBase.getUsers();

        System.out.println("Користувачі, які мають пошту gmail :");
        ArrayList<User> arrayListUsers = users
                .stream()
                .filter(e -> e.getEmail().endsWith(controlString))
                .collect(Collectors.toCollection(ArrayList::new));
        arrayListUsers.forEach(System.out::println);
        System.out.println();
    }

    public static void task6(){
        int controlAgeMin = 18, controlAgeMax = 30;
        List<User> users = DataBase.getUsers();

        System.out.println("Список email, що належать повнолітнім жінкам, не старшим за 30 років, які проживають в Україні та є співробітниками");
        ArrayList<String> arrayListEmails = users
                .stream()
                .filter(o -> o.getClass().getSimpleName().equals("Employee"))
                .map(u -> (Employee)u)
                .filter(e -> e.getGender() == Gender.WOMAN && e.getCountry() == Country.UKRAINE && e.getAge() >= controlAgeMin && e.getAge() <= controlAgeMax)
                .map(e -> e.getEmail())
                .collect(Collectors.toCollection(ArrayList::new));
        arrayListEmails.forEach(System.out::println);
    }
}
