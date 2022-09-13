package edu.itstep.cw20220912.interfaces;

public class Woman implements Soldier{
    private String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public void shoot() {
        System.out.println(name + " piu-piu");
    }
}
