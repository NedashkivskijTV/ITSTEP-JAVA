package edu.itstep.cw20221003_repeat.annotation;

public class Child extends Parent{
    public Child(String name) {
        super(name);
    }

    @Override
    //@SecondAnnotation(key = "one")
    //@SecondAnnotation("three")
    //@SecondAnnotation(value = "three")
    @SecondAnnotation(value = "three", key = {"one", "two"}, param = SecondAnnotation.Color.RED)
    public void info() {
        System.out.println("I'm CHILD!");
    }
}
