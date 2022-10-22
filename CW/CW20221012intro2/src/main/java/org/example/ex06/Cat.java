package org.example.ex06;

import org.springframework.stereotype.Component;

//@Component
@Component("myCat")
public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat");
    }
    @Override
    public void voice() {
        System.out.println("Mau");
    }
}
