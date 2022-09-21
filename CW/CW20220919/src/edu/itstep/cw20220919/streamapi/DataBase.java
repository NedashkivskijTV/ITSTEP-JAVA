package edu.itstep.cw20220919.streamapi;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    public static List<Human> getHumans(){
        List<Human> humans = new LinkedList<>();
        humans.add(new Human("Ivan", 20, Speciality.DEVELOPER));
        humans.add(new Human("Petr", 33, Speciality.DEVELOPER));
        humans.add(new Human("Stepan", 18, Speciality.DESIGNER));
        humans.add(new Human("Victoria", 40, Speciality.TESTER));
        humans.add(new Human("Olga", 15, Speciality.DESIGNER));
        humans.add(new Human("Svitlana", 30, Speciality.HR));
        return humans;
    }
}
