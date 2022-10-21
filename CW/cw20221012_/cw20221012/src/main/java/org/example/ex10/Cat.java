package org.example.ex10;

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
