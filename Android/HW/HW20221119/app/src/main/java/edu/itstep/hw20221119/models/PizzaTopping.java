package edu.itstep.hw20221119.models;

public enum PizzaTopping {
    MEAT(35),
    MUSHROOMS(20),
    CHEESE(10);

    private int cost;

    PizzaTopping(int cost) {
        this.cost = cost;
    }
}
