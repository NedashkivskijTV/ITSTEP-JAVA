package edu.itstep.cw20220912_rozbir.interfaces;

public class Man implements Soldier {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void shoot() {
        System.out.println(name + " tra-ta-ta ");
    }

    @Override
    public void march() {
        // додати код
        Soldier.super.march();
        // додати код
    }
}
