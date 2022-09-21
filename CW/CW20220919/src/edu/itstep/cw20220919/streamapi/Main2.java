package edu.itstep.cw20220919.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getHumans();

        // отримати дизайнерів - тільки імена та відсортувати
        List<String> names = new ArrayList<>();

        for (String name : names) {

        }
        System.out.println("-------------------------------------");
        List<String> names2 = humans
                .stream()
                .filter(human -> human.getSpeciality() == Speciality.DESIGNER)
                .map(Human::getName)
                .sorted()
                .collect(Collectors.toList());

        names2.forEach(System.out::println);
    }


}
