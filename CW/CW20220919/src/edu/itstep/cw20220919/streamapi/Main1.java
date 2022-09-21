package edu.itstep.cw20220919.streamapi;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getHumans();
        // чи є неповнолітні
        boolean result = false;

        for (Human human : humans) {
            if(human.getAge() < 18){
                result = true;
                break;
            }
        }
        System.out.println(result);
        System.out.println("------------------------------------------");

        final boolean resultAPI = humans
                .stream()
                .anyMatch(human -> human.getAge() < 18);
        System.out.println(resultAPI);

        System.out.println("------------------------------------------");
        final boolean resultAPI2 = humans
                .stream()
                .allMatch(human -> human.getName().length() > 4);
        System.out.println(resultAPI2);

        System.out.println("------------------------------------------");

    }

}
