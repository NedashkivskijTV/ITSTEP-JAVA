package org.example.ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet pet;

    public Person() {
        System.out.println("Person");
    }

    public void callPet(){
        System.out.println("Hello, my friend!");
        pet.voice();
    }

    public Pet getPet() {
        return pet;
    }

    @Autowired // створення залежності за допомогою сетера
    public void setPet(Pet pet) {
        System.out.println("setPet");
        this.pet = pet;
    }
}
