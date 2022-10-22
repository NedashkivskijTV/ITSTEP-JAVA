package org.example.ex081;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet pet;

    @Autowired
    public Person(@Qualifier("dog") Pet pet) {
        System.out.println("Person");
        this.pet = pet;
    }

    public void callPet(){
        System.out.println("Hello, my friend!");
        pet.voice();
    }

    public Pet getPet() {
        return pet;
    }
}
