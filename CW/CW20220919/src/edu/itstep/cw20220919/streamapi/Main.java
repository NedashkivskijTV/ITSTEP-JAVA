package edu.itstep.cw20220919.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getHumans();
        List<Human> developers = new ArrayList<>();

        // імперативний
        for (Human human : humans) {
            if(human.getSpeciality() == Speciality.DEVELOPER){
                developers.add(human);
            }
        }
        for (Human developer : developers) {
            System.out.println(developer);
        }

        // декларативний
        List<Human> developersD = humans
                .stream()
                .filter(human -> human.getSpeciality() == Speciality.DEVELOPER)
                .collect(Collectors.toList());

        System.out.println("-------------------------------------------------");
        for (Human human : developersD) {
            System.out.println(human);
        }

        System.out.println("-------------------------------------------------");
        developersD.forEach(System.out::println);
    }


}
