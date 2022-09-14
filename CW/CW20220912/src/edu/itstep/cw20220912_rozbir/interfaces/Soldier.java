package edu.itstep.cw20220912_rozbir.interfaces;

public interface Soldier {
    public static final int CAPTION = 1;
    void shoot();

    public default void march(){
        System.out.println("Marching straight");
    }

    static void sayHello(){
        System.out.println("Hello!");
    }

}
