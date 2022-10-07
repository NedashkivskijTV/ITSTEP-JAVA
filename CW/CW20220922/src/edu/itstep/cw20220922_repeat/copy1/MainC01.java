package edu.itstep.cw20220922_repeat.copy1;

public class MainC01 {
    public static void main(String[] args) {

        // Створення копій з використанням конструктора копій - працює при відсутності вкладеності ---------------------
        User user = new User("Ivan", "Ivanenko");
        User copy = new User(user);

        user.setFirstName("Petro");
        System.out.println(copy.getFirstName()); // Ivan - працює коректно доки об'єкт не має вищого ступеня вкладеності
    }
}
