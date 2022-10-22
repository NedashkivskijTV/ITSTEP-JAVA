package org.example.ex07;

//@Component
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog");
    }

    @Override
    public void voice() {
        System.out.println("Woof");
    }
}
