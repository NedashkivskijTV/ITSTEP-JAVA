package edu.itstep.cw20220912.interfaces;

public class Main {
    public static void main(String[] args) {
        Soldier soldier;
        Man man = new Man("Ivan");
        man.shoot();

        Woman woman= new Woman("Irina");
        woman.shoot();
        System.out.println("----------------------");
        commander(man, woman);
        System.out.println("----------------------");
        chef(man);
        System.out.println("----------------------");
        Soldier.sayHallo();
    }

    public static void commander(Soldier... soldiers){
        System.out.println("FIRE!!!");
        for (Soldier soldier : soldiers) {
            soldier.shoot();
        }
        System.out.println("MARCH!!!");
        for (Soldier soldier : soldiers) {
            soldier.march();
        }

    }

    public static void chef(Cook... cooks){
        System.out.println("Peel potatoes!!!");
        for (Cook cook : cooks) {
            cook.cook();
        }
    }
}
