package edu.itstep.cw20220919.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {

        List<Human> humans = DataBase.getHumans();

        // згрупувати людей за спуціальностями в різні колекції
        // потрібно також розуміти, скільки маємо спуціальностей
        // результат зберігати у map(ключ-спеціальність, значення - список human)

        Map<Speciality, List<Human>> map = humans
                .stream()
                .collect(Collectors.groupingBy(Human::getSpeciality));

        map.forEach(((speciality, group) -> {
            System.out.println(speciality);
            group.forEach(System.out::println);
        }));
    }
}
