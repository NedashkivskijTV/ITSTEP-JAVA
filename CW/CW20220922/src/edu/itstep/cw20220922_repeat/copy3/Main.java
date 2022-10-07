package edu.itstep.cw20220922_repeat.copy3;

public class Main {
    public static void main(String[] args) {

        // Створення копій при наявності вкладеності -------------------------------------------------------------------
        User user = new User("Ivan", "Ivanenko", new Address("Ivanjva", "55"));
        User copy = new User(user);

        user.getAddress().setNumber("777");
        System.out.println(copy.getAddress().getNumber());
    }
}
