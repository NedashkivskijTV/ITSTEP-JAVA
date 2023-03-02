package edu.itstep.cw20220907;

public class Main01 {
    public static void main(String[] args) {

        //System.out.println("Hello !!!");

        /**
         * Приклад збереження посилання на об'єкт нащадка у масиві з типом батьківського класу
         *  - застосування поліморфізму
         *
         * При такому підході відбувається втрата функціоналу !!! -
         * у кожного елемента даного масива доступним є застосування лише функціоналу батьківського класу,
         * оскільки посилання на об'єкт дочірнього класу зберігається у змінній типу батьківського класу
         */

        // масив фігур - посилань на об'єкти класів - нащадків
        /** До такого масиву можна покласти об'єкт будь якого класу за умови, що він (клас) є нащадком класу Shape */
        Shape[] shapes = {
           new Circle(ColorConst.GREEN, ColorConst.RED, 3),
           new Circle(ColorConst.GREEN, ColorConst.RED, 4),
           new Circle(ColorConst.GREEN, ColorConst.RED, 5),
           new Rectangle(ColorConst.RED, ColorConst.RED, 3, 3),
           new Rectangle(ColorConst.RED, ColorConst.RED, 4, 4),
           new Rectangle(ColorConst.RED, ColorConst.RED, 5, 5),
        };

        /** Варіанти створення/наповнення масиву дочірніх об'ктів */
        Shape[] shape1 = new Shape[6];
        Circle circle1 = new Circle(ColorConst.RED, ColorConst.GREEN, 7);
        Circle circle2 = new Circle(ColorConst.RED, ColorConst.GREEN, 7);
        Circle circle3 = new Circle(ColorConst.RED, ColorConst.GREEN, 7);
        shape1[0] = circle1;
        shape1[1] = circle2;
        shape1[2] = circle3;
        shape1[3] = new Rectangle(3, 3);
        shape1[4] = new Rectangle(3, 3);
        shape1[5] = new Rectangle(3, 3);


        // Алгоритм розрахунку спільної площі усіх фігур масиву - використання перевизначеного методу calcArea() -
        // приклад застосування поліморфізму
        double sumArea = 0;
        for (Shape shape : shapes) {
            sumArea += shape.calcArea();
        }
        System.out.println("\nsumArea = " + sumArea);
    }
}
