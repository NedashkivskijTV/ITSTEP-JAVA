package org.example.ex2;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        System.out.println("Person");
        this.pet = pet;
    }

    public void callPet(){
        System.out.println("Hello, my friend!");
        pet.voice();
    }
}
