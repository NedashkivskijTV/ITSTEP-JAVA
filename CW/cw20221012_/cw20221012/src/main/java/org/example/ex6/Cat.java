package org.example.ex6;

import org.springframework.stereotype.Component;

//@Component("myCat")
@Component
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat");
    }

    @Override
    public void voice(){
        System.out.println("MIU");
    }
}
