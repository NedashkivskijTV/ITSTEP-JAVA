package edu.itstep.cw20221003.annotation;

public class Child extends Parent{

    public Child(String name) {
        super(name);
    }

    @Override
    public void info() {
        System.out.println("I`m CHILD");
    }
}
