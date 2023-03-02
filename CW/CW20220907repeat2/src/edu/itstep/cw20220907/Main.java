package edu.itstep.cw20220907;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Rectangle rectangle = new Rectangle("red", ColorConst.GREEN, 3, 4);
        Circle circle = new Circle("yellow", ColorConst.GREEN, 5);

        /** різноманітні варіанти виведення даних про екземпляр */
        System.out.println();
        System.out.println(rectangle.toString()); // роздруковує ссилку
        System.out.println(rectangle); // все одно викликається метод toString() - роздруковує ссилку
        rectangle.print();


        /** виведення результатів обчислення площі різних фігур */
        System.out.println();
        System.out.println(rectangle.calcArea());
        System.out.println(circle.calcArea());

    }
}