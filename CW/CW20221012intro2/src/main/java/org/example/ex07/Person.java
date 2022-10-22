package org.example.ex07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet pet;

    @Autowired // може не вказуватись
    // Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    // визначити придатний для впровадження залежності конструктор та використати
    // його при створенні об’єкта
    public Person(Pet pet) {
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
