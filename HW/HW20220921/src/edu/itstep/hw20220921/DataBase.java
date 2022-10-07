package edu.itstep.hw20220921;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivanenko Ivan", 33, Gender.MAN, "ivanenko@gmail.com", Country.UKRAINE));
        users.add(new User("Petrenco Petro", 27, Gender.MAN, "petrenko@ukr.net", Country.UKRAINE));
        users.add(new User("Semenenko Svitlana", 17, Gender.WOMAN, "semenenko@gmail.com", Country.ENGLAND));
        users.add(new Employee("Ivanenko Ivan", 33, Gender.MAN, "ivanenko@gmail.com", Country.UKRAINE, 11000, JobTitle.MANAGER, Department.SALES_DEPARTMENT));
        users.add(new Employee("Sergienko Sergij", 27, Gender.MAN, "serg_s@gmail.com", Country.GERMANY, 53000, JobTitle.DEVELOPER, Department.DEVELOPMENT_DEPARTMENT));
        users.add(new Employee("Danilov Danilo", 25, Gender.MAN, "danilov_d@gmail.com", Country.LUXEMBOURG, 50000, JobTitle.DEVELOPER, Department.DEVELOPMENT_DEPARTMENT));
        users.add(new Employee("Shevchenko Lilija", 20, Gender.WOMAN, "shevchenko_lili@ukr.net", Country.UKRAINE, 50000, JobTitle.DEVELOPER, Department.DEVELOPMENT_DEPARTMENT));
        users.add(new Employee("Antonenko Anna", 22, Gender.WOMAN, "antonenkoa@gmail.com", Country.UKRAINE, 10000, JobTitle.MANAGER, Department.SALES_DEPARTMENT));
        users.add(new Employee("Ivanova Inna", 16, Gender.WOMAN, "ivanova@gmail.com", Country.UKRAINE, 12000, JobTitle.DESIGNER, Department.DESIGNERS_GROUP));
        users.add(new Employee("Andrieva Olga", 29, Gender.WOMAN, "andrieva_o@ukr.net", Country.FRANCE, 10500, JobTitle.HR, Department.HR_DEPARTMENT));

        return users;
    }
}
