package edu.itstep.hw20220901;

public class Main02 {
    public static void main(String[] args) {
        int n = 5; // ряди
        int m = 10; // місця
        int k = 4; // кількість квитків, що потрібно придбати (сусідні місця в одному ряду)
        //int[][] cinema = new int[n][m]; // масив місць у кінотеатрі

        // заповнення масиву "випадковими" значеннями
        int[][] cinema = {
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0}
        };

        // виведення створеного масиву - масиву зайнятих/вільних місць у кінотеатрі
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cinema[i][j] + "  ");
            }
            System.out.println();
        }


        // визначення - чи є потрібна кількість вільних місць у одному ряду
        int placeCount = k;
        boolean freePlacesRow = false;

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
