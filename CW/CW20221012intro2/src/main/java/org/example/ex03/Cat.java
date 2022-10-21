package org.example.ex03;

public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat");
    }
    @Override
    public void voice() {
        System.out.println("Mau");
    }
}
