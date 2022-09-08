package edu.itstep.hw20220907;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Store {
    private Refrigerator[] refrigerators;
    private Tvset[] tvsets;
    private Kettle[] kettles;

    public Store() {
        DB db = new DB();
        this.refrigerators = db.getRefrigeratorsDB();
        this.tvsets = db.getTvsetsDB();
        this.kettles = db.getKettlesDB();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        Product[][] products = new Product[][]{
                refrigerators,
                tvsets,
                kettles
        };

        int choiceCategory = 0;
        System.out.println();
        System.out.println("Каталог товарів");
        do {
            choiceCategory = userChoiceMenu(scanner, products, null,
                    "",
                    "Перелік доступних категорій :",
                    "Оберіть код категорії товарів або 0 для виходу та натисніть ENTER - ");
            if (choiceCategory != 0) {
                productMenu(products[choiceCategory - 1], scanner);
            }
        } while (choiceCategory != 0);
        System.out.println();
        System.err.println("Роботу програми завершено");
    }

    private void incorrectInput(int firstNumber, int lastNumber) {
        System.err.println("УВАГА ! Введено некоректні дані !");
        System.err.println("Має бути введено ціле число від " + firstNumber + " до " + lastNumber);
        System.err.println("Спробуйте ще раз");
        System.err.println();
    }

    private void productMenu(Product[] products, Scanner scanner) {
        int choiceProduct = 0;
        do {
            choiceProduct = userChoiceMenu(scanner, null, products,
                    "Обрано категорію товарів - " + products[0].getProductType(),
                    "Перелік доступних товарів даної категорії :",
                    "Оберіть код товару або 0 для повернення у попереднє меню та натисніть ENTER - ");
            if (choiceProduct != 0) {
                int choiseExit = 0;
                System.out.println();
                System.out.println("Обрано наступний товар :");
                //==========================================================================================================================
                //products[choiceProduct - 1].print();
                System.out.println(products[choiceProduct - 1]);
                System.out.println("---------------------------------------------------------");
                System.out.print("Для повернення у попереднє меню оберіть О та натисніть ENTER - ");
                do {
                    choiseExit = scanner.nextInt();
                } while (choiseExit != 0);
            }
        } while (choiceProduct != 0);
    }

    private int userChoiceMenu(Scanner scanner, Product[][] productsAll, Product[] products, String title1, String title2, String choiceDesc) {
        int choice = 0;
        int productsMassivLenght = 0;
        do {
            System.out.println();
            System.out.println(title1);
            System.out.println(title2);
            if (productsAll == null) {
                showCategoryOrProduct(products);
                productsMassivLenght = products.length;
            } else {
                showCategoryOrProduct(productsAll);
                productsMassivLenght = productsAll.length;
            }
            System.out.println("---------------------------------------------------------");
            System.out.print(choiceDesc);
            choice = scanner.nextInt();
            if (choice < 0 || choice > productsMassivLenght) {
                incorrectInput(0, productsMassivLenght);
            }
        } while (choice < 0 || choice > productsMassivLenght);
        return choice;
    }

    private void showCategoryOrProduct(Product[][] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.print((i + 1) + " - ");
            System.out.println(products[i][0].getProductType());
        }
    }

    private void showCategoryOrProduct(Product[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i + 1) + " - ");
            arr[i].printShort();
            System.out.println();
        }
    }

}
