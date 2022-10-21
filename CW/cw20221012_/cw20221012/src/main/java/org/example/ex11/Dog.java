package org.example.ex11;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog");
    }

    @Override
    public void voice() {
        System.out.println("WOF");
    }
}
