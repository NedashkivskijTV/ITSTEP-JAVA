package org.example.ex7;

//@Component
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog");
    }

    @Override
    public void voice() {
        System.out.println("WOF");
    }
}
