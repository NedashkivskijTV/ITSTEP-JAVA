package edu.itstep.cw20220912_rozbir.interfaces;

public class Main {
    public static void main(String[] args) {
        Soldier soldier;

        Man man = new Man("Petro");
        //man.shoot();

        Woman woman = new Woman("Olena");
        //woman.shoot();

        commander(man, woman);
        chef(woman);

        Soldier.sayHello();
    }

    public static void commander(Soldier... soldiers){ // Soldier... - аргумент змінної довжини
        System.out.println("FIRE!!!");
        for (Soldier soldier : soldiers) {
            soldier.shoot();
        }
        System.out.println("We won! All at home!");
        for (Soldier soldier : soldiers) {
            soldier.march();
        }
    }

    public static void chef(Cook... cooks){
        System.out.println("Peel 5 buckets of potatoes!");
        for (Cook cook : cooks) {
            cook.cook();
        }
    }

}
