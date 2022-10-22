package org.example.ex08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
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
}
