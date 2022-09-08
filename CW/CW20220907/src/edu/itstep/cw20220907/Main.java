package edu.itstep.cw20220907;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("red", ColorConst.GREEN, 3, 4);
        Circle circle = new Circle("yellow", ColorConst.GREEN, 5);

        System.out.println(rectangle.toString()); // роздруковує ссилку
        System.out.println(rectangle); // все одно викликається метод toString() - роздруковує ссилку
        rectangle.print();

    }
}
