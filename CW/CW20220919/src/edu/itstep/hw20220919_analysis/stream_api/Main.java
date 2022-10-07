package edu.itstep.hw20220919_analysis.stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // get only developers
        System.out.println("get only developers");
        List<Human> humans = DataBase.getHuman();
/*
        List<Human> developers = new ArrayList<>();

        // імперативний підхід
        for (Human human : humans) {
            if(human.getSpeciality() == Speciality.DEVELOPER){
                developers.add(human);
            }
        }

        // роздрук
        for (Human developer : developers) {
            System.out.println(developer);
        }
*/
        // декларативний підхід
        List<Human> developers = humans
                .stream()       // метод, що повертає обєкт класу Stream (потік) - перетворює колекцію на потік, з яким доступні певні маніпуляції
                .filter(h -> h.getSpeciality() == Speciality.DEVELOPER) // проміжний - приймає реалізацію інтерфуйса предікат
                .collect(Collectors.toList());

        // роздрук
/*
        for (Human developer : developers) {
            System.out.println(developer);
        }
*/
        // роздрук - короткий запис із застосуванням посилання на метод класу
        developers.forEach(System.out::println);

        System.out.println("==============================================================================");
        System.out.println();
        System.out.println("Чи є у списку неповнолітні");
        // чи є неповнолітні
/*
        // імперативний підхід
        boolean res = false;
        for (Human human : humans) {
            if(human.getAge() < 18){
                res = true;
                break;
            }
        }
        System.out.println(res);
        */

        // декларативний підхід
        final boolean result = humans
                .stream()
                .anyMatch(h -> h.getAge() < 18); // термінальний - знаходить хоча б 1 - повертає true, приймає реалізацію інтерфейса предікат
        System.out.println(result);

        System.out.println("==============================================================================");
        System.out.println();
        System.out.println("чи всі імена працівників довші за 2 символи");
        // чи всі імена працівників довші за 2 символи
/*
        // імперативний підхід
        */

        // декларативний підхід
        final boolean res1 = humans
                .stream()
                .allMatch(h -> h.getName().length() > 2);  // термінальний - якщо усі відповідають умові - повертає true, приймає реалізацію інтерфейса предікат
        System.out.println(res1);

        System.out.println("==============================================================================");
        System.out.println();
        System.out.println("Отримати обєкти дизайнерів, тільки імена, відсортувати");
        // Отримати обєкти дизайнерів, тільки імена, відсортувати

/*
        // імперативний підхід
        List<String> names = new ArrayList<>();
        for (Human human : humans) {
            if(human.getSpeciality() == Speciality.DESIGNER){
                names.add(human.getName());
            }
        }
        Collections.sort(names);
        names.forEach(System.out::println);
*/

        // декларативний підхід
        List<String> names = humans
                .stream()
                .filter(h -> h.getSpeciality() == Speciality.DESIGNER)
                .map(h -> h.getName()) // проміжний, приймає інтерфейс Function - отримує обєкт, перетворює його на іншу сутність, повертає у колекцію
                .sorted() // сортує інформацію
                .collect(Collectors.toList()); // формує колекцію List
        names.forEach(System.out::println);
        System.out.println("==============================================================================");

        System.out.println();
        System.out.println("Відібрати людей у різні колекції за спеціальностями, " +
                "кількість спеціальностей заздалегідь невідома," +
                "результати зберігати у map(ключ - спеціальність, значення - список з human)");
        // Відібрати людей у різні колекції за спеціальностями
        // кількість спеціальностей заздалегідь невідома,
        // результати зберігати у map(ключ - спеціальність, значення - список з human)

        // імперативний підхід

        // декларативний підхід
        Map<Speciality, List<Human>> map = humans
                .stream()
                .collect(Collectors.groupingBy(Human::getSpeciality)); // термінальний - приймає посилання на метод, по якому буде групуватись інф, як параметр методу groupingBy класу Collectors
        map.forEach(((speciality, group) -> {
            System.out.println(speciality);
            group.forEach(System.out::println);
        }));
    }

}
