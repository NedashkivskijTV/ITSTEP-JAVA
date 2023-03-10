package edu.mywork.ProductStore.Models;

import java.util.List;
import java.util.Scanner;

public class Store {
    private Product[][] productDB;
    private Scanner scanner;

    private final String[][] correctChoices = new String[][]{
            new String[]{"yes", "no", "y", "n", ""},
            new String[]{"y", "yes", ""},
            new String[]{"0", ""},
    };

    public Store() {
        this.productDB = DataBase.getProductDB();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Основний метод - єдиний доступний ззовні - запуск програми
     */
    public void start() {
        System.out.println("\nPRODUCT CATALOG");
        System.out.print("Would you like to start working with the program? (y/n) - ");
        if (lineCheck(lineInputControl(""), correctChoices[1])) {
            productCatalog();
        }
        System.err.println("The work of the program is completed");
    }

    /**
     * Формування списку категорій та діалог вибору категорії
     */
    private void productCatalog() {
        System.out.println();
        System.out.println("PRODUCT CATALOG - CATEGORIES");
        String userChoice = "";
        int userChoiceToInt;
        do {
            System.out.println("Categories of products");
            int numberOfCategory = 1;
            for (Product[] products : productDB) {
                System.out.print(numberOfCategory++ + " - ");
                System.out.println(products[0].getProductType().getProductTypeNameEnPlural());
            }
            System.out.println("=========================================================");
            System.out.println("Enter the category number or 0 for exit");

            userChoice = lineInputControl("Enter the category number or 0 for exit", massiveOfCategoriesNumbers(productDB.length));
            if (!userChoice.equals("0")) {
                userChoiceToInt = Integer.parseInt(userChoice);
                productMenu(productDB[userChoiceToInt - 1]);
            }
        } while (!(userChoice.equals("0")));
    }

    /**
     * Формування масиву допустимих відповідей для дуалогів вибору користувачем одного варіанту з переліку запропонованих + 0 для виходу у попереднє меню
     *
     * @param massiveLength - довжина колекції, що відображається - містить порядкові номери, які може обирати корисувач
     * @return - масив рядків, що містить допустимі відповіді
     */
    private String[] massiveOfCategoriesNumbers(int massiveLength) {
        String[] numbersMass = new String[massiveLength + 1];
        for (int i = 0; i <= massiveLength; i++) {
            numbersMass[i] = "" + i;
        }
        return numbersMass;
    }

    /**
     * Формування переліку доступних товарів обраної категорії, діалог вибору товару, відображення повної інформації про обраний товар, а також відповідні діалоги з користувачем
     *
     * @param products - масив товарів, обраної раніше категорії
     */
    private void productMenu(Product[] products) {
        System.out.println();
        System.out.println("PRODUCT CATALOG - PRODUCTS");
        String userChoice = "";
        int userChoiceToInt;
        do {

            System.out.println("Products of category " + products[0].getProductType().getProductTypeNameEnPlural());
            int numberOfProduct = 1;
            for (Product product : products) {
                System.out.print(numberOfProduct++ + " - ");
                product.printShort();
                System.out.println();
            }
            System.out.println("=========================================================");
            System.out.println("Enter the product number or 0 for exit");

            userChoice = lineInputControl("Enter the product number or 0 for exit", massiveOfCategoriesNumbers(products.length));
            if (!userChoice.equals("0")) {
                userChoiceToInt = Integer.parseInt(userChoice);
                System.out.println(products[userChoiceToInt - 1]);
                System.out.println("=========================================================");
                System.out.println("Enter 0 for exit");
                lineInputControl("Enter 0 for exit", correctChoices[2]);
            }
        } while (!(userChoice.equals("0")));
    }

    /**
     * Перевірка коректності вводу користувачем тексту, використовується масив допустимих варіантів вводу
     *
     * @param message     - рядок - повідомлення, що виводиться при некоректному вводі
     * @param correctLine - масив рядків - колекція допустимих відповідей
     * @return - рядок - введений користувачем рядок (з колекції допустимих відповідей)
     */
    private String lineInputControl(String message, String... correctLine) {
        if (message == null || message.length() == 0) { // Формування повідомлення, що виведеться за замовчуванням
            message = "Введіть yes/no та Enter";
        }
        if (correctLine == null || correctLine.length == 0) { // Формування колекції допустимих відповідей за замовчуванням
            correctLine = correctChoices[0]; // "yes", "no", "y", "n", ""
        }
        String userLine = scanner.nextLine();
        while (!lineCheck(userLine, correctLine)) {
            System.out.println("\n" + message);
            userLine = scanner.nextLine();
        }
        return userLine;
    }

    /**
     * Перевірка коректності ввода - наявності значення, переданого у параметрі line серед елементів масива у параметрі possibleLines
     *
     * @param line          - рядок - введений користувачем рядок
     * @param possibleLines - масив рядків - колекція коректних варіантів, що можуть бути введені користувачем
     * @return - boolean - повертає true у разі наявності у колекції значення, введеного користувачем, інакше - false
     */
    private boolean lineCheck(String line, String... possibleLines) {
        return List.of(possibleLines).stream().anyMatch(l -> l.equalsIgnoreCase(line));
    }
}
