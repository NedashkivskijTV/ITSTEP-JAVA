package org.example.ex3;

public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat");
    }

    @Override
    public void voice(){
        System.out.println("MIU");
    }
}
