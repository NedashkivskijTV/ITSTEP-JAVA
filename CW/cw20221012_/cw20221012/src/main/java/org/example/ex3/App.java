package org.example.ex3;

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

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

//        Pet pet = (Pet) context.getBean("myPet");
//        pet.voice();

        Person person = context.getBean("person2", Person.class);
        person.callPet();
        System.out.println(person.getFullName());
        System.out.println(person.getAge());
    }
}
