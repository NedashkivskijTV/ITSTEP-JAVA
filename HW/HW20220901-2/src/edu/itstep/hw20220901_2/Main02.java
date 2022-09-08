package edu.itstep.hw20220901_2;

import java.util.Random;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {

        int n = 0; // ряди
        int m = 0; // місця
        int k = 0; // кількість квитків, що потрібно придбати (сусідні місця в одному ряду)
        Random random = new Random(); // рандомізатор для заповнення масива
        Scanner scanner = new Scanner(System.in); // створено для роботи з потоком - ввод даних з клавіатури

        System.out.print("Введіть кількість рядів у кінозалі - ");
        n = scanner.nextInt();
        System.out.print("Введіть кількість місць у рядах кінозалу - ");
        m = scanner.nextInt();

        int[][] cinema = new int[n][m]; // масив місць у кінотеатрі

        // заповнення масиву "випадковими" значеннями
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cinema[i][j] = random.nextInt(2);
            }
        }

        // виведення створеного масиву - масиву зайнятих/вільних місць у кінотеатрі
        System.out.println();
        System.out.println("Масив місць у кінотеатрі (0 - вільно, 1 - зайнято)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cinema[i][j] + "  ");
            }
            System.out.println();
        }


        // визначення - чи є потрібна кількість вільних місць у одному ряду
        System.out.println();
        System.out.print("Введіть потрібну кількість вільних місць в одному ряду - ");
        k = scanner.nextInt();

        int placeCount = k;
        boolean freePlacesRow = false, header = true;

        //System.out.println("Наявні варіанти");
        for (int i = 0; i < n; i++) {
            freePlacesRow = false;
            for (int j = 0; j < m; j++) {
                placeCount = k;
                for (int l = j; l < j + k && l < m; l++) {
                    if (cinema[i][l] == 1) {
                        break;
                    } else {
                        --placeCount;
                    }
                }
                //System.out.println("-----------------------");
                //System.out.print("placeCount = "); System.out.println(placeCount);

                // виведення списку варіантів у разі їх наявності
                if (placeCount == 0) {
                    if (freePlacesRow == false) {
                        freePlacesRow = true;
                        if(header == true){
                            header = false;
                            System.out.println("Наявні наступні варіанти :");
                        }
                        System.out.print("row = ");
                        System.out.println(i);
                    }
                    System.out.print("place : ");
                    for (int l = j; l < j + k && l < m; l++) {
                        System.out.print(l + "  ");
                    }
                    System.out.println();
                }
            }
        }


    }
}
