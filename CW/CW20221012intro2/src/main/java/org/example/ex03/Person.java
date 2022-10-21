package org.example.ex03;

public class Person {
    private Pet pet;
    private String fullName;
    private int age;

    public Person() {
        System.out.println("Person");
    }

    public Person(Pet pet, String fullName, int age) {
        this.pet = pet;
        this.fullName = fullName;
        this.age = age;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
