package edu.itstep.cw20220909.blocks;

public class Parent {
    public int publicParent = 1; //змінна екземпляра
    public static int staticPublicParent = 11; //змінна класу
    { //блок (НЕстатичний)
        System.out.println("non static block Parent");
    }
    static { //блок СТАТИЧНИЙ
        System.out.println("static block Parent");
    }
    public Parent() {
        //System.out.println(this);
        System.out.println("Parent");
    }
}
