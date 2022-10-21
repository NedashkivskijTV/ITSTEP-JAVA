package org.example.ex01;

public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat");
    }
    @Override
    public void voice() {
        System.out.println("Mau");
    }
}
