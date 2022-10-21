package org.example.ex02;

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

    public void setPet(Pet pet) {
        System.out.println("setPet");
        this.pet = pet;
    }
}
