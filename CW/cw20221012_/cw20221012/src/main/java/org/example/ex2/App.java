package org.example.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        /System.out.println( "Hello World!" );
//        Cat cat = new Cat();
//        cat.voice();

//        Pet pet = new Dog();
//        pet.voice();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

//        Pet pet = (Pet) context.getBean("myPet");
//        pet.voice();

        Person person = context.getBean("myPerson", Person.class);
        person.callPet();
    }
}
