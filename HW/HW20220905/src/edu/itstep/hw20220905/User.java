package edu.itstep.hw20220905;

import java.sql.SQLOutput;

public class User {
    public String firstName = "No name";
    public String lastName = "No name";
    public int age = 0;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void PrintUser() {
        System.out.println("firstName : " + this.firstName + ", lastName : " + this.lastName + ", age : " + this.age);
    }

}
