package edu.itstep.cw20221003.annotation;

public class Parent {
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

    public void info(){
        System.out.println("I`m parent");
    }
}
