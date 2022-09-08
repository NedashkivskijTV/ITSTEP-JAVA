package edu.itstep.cw20220907;

public class Main01 {
    public static void main(String[] args) {
        Shape[] shapes = {
          new Circle(ColorConst.GREEN, ColorConst.RED, 3),
          new Circle(ColorConst.GREEN, ColorConst.RED, 4),
          new Circle(ColorConst.GREEN, ColorConst.RED, 5),
          new Rectangle(ColorConst.GREEN, ColorConst.RED, 3, 3),
          new Rectangle(ColorConst.GREEN, ColorConst.RED, 4, 4),
          new Rectangle(ColorConst.GREEN, ColorConst.RED, 5, 5),
        };

        Shape[] shape1 = new Shape[6];
        Circle circle1 =  new Circle(ColorConst.RED, ColorConst.GREEN, 7);
        Circle circle2 =  new Circle(ColorConst.RED, ColorConst.GREEN, 7);
        Circle circle3 =  new Circle(ColorConst.RED, ColorConst.GREEN, 7);
        shape1[0] = circle1;
        shape1[1] = circle2;
        shape1[2] = circle3;
        shape1[3] = new Rectangle(3, 3);
        shape1[4] = new Rectangle(3, 3);
        shape1[5] = new Rectangle(3, 3);


        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calcArea();
        }
        System.out.println(sum);
    }
}
