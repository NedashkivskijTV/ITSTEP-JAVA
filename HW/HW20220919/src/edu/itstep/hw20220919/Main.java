package edu.itstep.hw20220919;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Відібрати людей у різні колекції за спеціальностями
        // кількість спеціальностей заздалегідь невідома,
        // результати зберігати у map(ключ - спеціальність, значення - список з human)

        List<Human> humans = DataBase.getHuman();

        // декларативний підхід
        Map<Speciality, List<Human>> map = humans
                .stream()
                .collect(Collectors.groupingBy(Human::getSpeciality)); // термінальний - приймає посилання на метод, по якому буде групуватись інф, як параметр методу groupingBy класу Collectors

        printMap(map);

        System.out.println("===================================================");

        // імперативний підхід
        Map<Speciality, List<Human>> mapDeclarative = new HashMap<>();
        for (Speciality value : Speciality.values()) {
            List<Human> temp = new ArrayList<>();
            for (Human human : humans) {
                if (human.getSpeciality() == value) {
                    temp.add(human);
                }
            }
            if (temp.size() != 0) {
                mapDeclarative.put(value, temp);
            }
        }

        printMap(mapDeclarative);
    }

    public static void printMap(Map<Speciality, List<Human>> map) {
        map.forEach(((speciality, group) -> {
            System.out.println(speciality);
            group.forEach(System.out::println);
        }));
    }
}
