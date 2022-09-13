package edu.itstep.cw20220912.interfaces;

public class Man implements Soldier, Cook{
    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void shoot() {
        System.out.println(this.name + " ta-ta-ta");
    }

    @Override
    public void cook() {
        System.out.println(this.name + " cook");
    }

    @Override
    public void march() {
        //додати власний функціонал
        Soldier.super.march();
        //додати власний функціонал
    }
}
