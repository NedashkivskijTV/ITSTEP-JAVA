package edu.itstep.cw20220909.blocks;

public class Child extends Parent{
    public int publicChild = 2; //змінна екземпляра
    public static int staticPublicChild = 22; //змінна класу
    { //блок (НЕстатичний)
        System.out.println("non static block Child");
        //доступні нестатичні та статичні змінні
        //System.out.println(publicChild);
        //System.out.println(staticPublicChild);
    }
    static { //блок СТАТИЧНИЙ
        System.out.println("static block Child");
        //доступні лише статичні змінні
        //System.out.println(publicChild);// нестатична змінна недоступна
        //System.out.println(staticPublicChild);
    }
    public Child() {
        //System.out.println(this);
        System.out.println("Child");
    }
}
