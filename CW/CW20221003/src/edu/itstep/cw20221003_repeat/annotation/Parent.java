package edu.itstep.cw20221003_repeat.annotation;

//@FirstAnnotation
@FirstAnnotation(key1 = 7, key2 = 77)
public class Parent {
    @FirstAnnotation(key1 = 1)
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("I'm parent!");
    }
}
