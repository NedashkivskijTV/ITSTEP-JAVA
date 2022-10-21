package org.example.ex03;

public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog");
    }

    @Override
    public void voice() {
        System.out.println("Woof");
    }
}
