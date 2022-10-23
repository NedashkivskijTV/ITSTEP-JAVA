package org.example.ex13;

public class Person {
    private Pet pet;
    private String fullName;
    private int age;

    public Person() {
        System.out.println("Person");
    }

    public Person(Pet pet) { // конструктор, що може використовуватись для реалізації DI (впровадження замежностей)
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

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}
