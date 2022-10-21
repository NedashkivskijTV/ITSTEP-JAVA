package org.example.ex13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet pet;
    private String fullName;
    private int age;

    public Person(){
        System.out.println("Person");
    }

//    public Person(Pet pet, String fullName, int age) {
//        System.out.println("Person");
//        this.pet = pet;
//        this.fullName = fullName;
//        this.age = age;
//    }

    public void callPet(){
        System.out.println("Hello, my friend!");
        pet.voice();
    }

    public String getFullName() {
        return fullName;
    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
