package edu.itstep.cw20220909.inner_classes.local;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Object result = outer.start();
        //result.innerMethod(); // помилка - до функціоналу даного класу
                                // доступ отримати неможлитво - доступний
                                //тільки функціонал Object
    }
}
