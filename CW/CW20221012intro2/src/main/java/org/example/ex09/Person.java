package org.example.ex09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired // вказує на створення залежності за допомогою даного сетера / конструктора / поля
    @Qualifier("dog") // вказує на те, який бін має бути використаний у якості залежності, якщо в робочій папці існують декілька класів, що можуть бути використані у якості залежності при створенні об’єкта
    private Pet pet;
    @Value("Ivan Ivanenko") // використовується для наповнення полів примітивами
    private String fullName;
    @Value("22") // використовується для наповнення полів примітивами
    private int age;

    public Person() {
    }

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

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}
