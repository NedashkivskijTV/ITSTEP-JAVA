package edu.itstep.cw20220912_rozbir.interfaces;

public class Woman implements Soldier, Cook {
    private String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public void shoot() {
        System.out.println(name + " piu-piu ");
    }

    @Override
    public void cook() {
        System.out.println("I start cooking");
    }
}
