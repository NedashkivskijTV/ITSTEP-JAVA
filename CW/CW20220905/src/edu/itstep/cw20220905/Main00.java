package edu.itstep.cw20220905;

import java.util.Random;
import java.util.Scanner;

public class Main00 {
    public static void main(String[] args) {

        // рандомізація масиву
        int [][] arr = new int[2][3];
        Random random = new Random();

        // робота з потоком
        Scanner scanner = new Scanner(System.in);
        //int bount = scanner.nextLine(); // зчитування рядка
        //int bount = scanner.next(); // зчитування рядка до першого пробіла
        System.out.println("Введіть число");
        //int bount = scanner.nextInt();
        int bount = 10;
        System.out.println(bount);

        // алгоритм заповнення/роздруку масиву
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                //arr[i][j] = random.nextInt(10) + 1; // ctrl + P - 3 -> 0-2
                arr[i][j] = random.nextInt(bount); // ctrl + P - 3 -> 0-2
                //System.out.print(arr[i][j] + "  ");
            }
            //System.out.println();
        }

        // роздрук
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }



    }
}
