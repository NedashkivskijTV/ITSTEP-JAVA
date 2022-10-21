package org.example.ex9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    @Qualifier("dog")
    private Pet pet;
    //@Value("Ivan Ivanov")
    @Value("@{person.fullName}")
    private String fullName;
    //@Value("33")
    @Value("@{person.age}")
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
