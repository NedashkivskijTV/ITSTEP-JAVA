package org.example.ex12;

import org.example.Pet;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet {
    private String name;

    public Cat() {
        System.out.println("Cat");
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void voice(){
        System.out.println("MIU");
    }
}
