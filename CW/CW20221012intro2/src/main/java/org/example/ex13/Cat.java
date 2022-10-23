package org.example.ex13;

public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat");
    }

    @Override
    public void voice() {
        System.out.println("Mau");
    }
}
