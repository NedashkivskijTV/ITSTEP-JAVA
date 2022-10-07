package edu.itstep.hw20220919;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Human> getHuman(){
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Ivan", 20, Speciality.DEVELOPER));
        humans.add(new Human("Petr", 33, Speciality.DEVELOPER));
        humans.add(new Human("Stepan", 18, Speciality.DESIGNER));
        humans.add(new Human("Victoria", 40, Speciality.TESTER));
        humans.add(new Human("Olga", 15, Speciality.DESIGNER));
        humans.add(new Human("Artur", 55, Speciality.TESTER));
        humans.add(new Human("Artem", 15, Speciality.DEVELOPER));
        humans.add(new Human("Bogdan", 77, Speciality.DESIGNER));
        humans.add(new Human("Svitlana", 22, Speciality.HR));
        return humans;
    }
}
