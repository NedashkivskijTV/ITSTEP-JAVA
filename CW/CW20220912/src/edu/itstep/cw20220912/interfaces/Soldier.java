package edu.itstep.cw20220912.interfaces;

public interface Soldier {
    int CAPTION = 1;
    void shoot();

    default void march(){
        System.out.println("Marching straight");
    }

    static void sayHallo(){
        System.out.println("Hello");
    }
}
