package edu.itstep.cw20220912.lambda;

public class Main {
    public static void main(String[] args) {
        //const int sum = (a, b) => a + b;

        Calculator sum = (x, y) -> x + y;
        Calculator division = (x, y) -> {
            if (y == 0) {
                System.out.println("/0 !!!");
                return 0;
            }
            return x / y;
        };
        double result = sum.execute(2, 2);

//        Printer printer = message -> {
//            //System.out.println("MESSAGE: " + message);
//            String decoration = "------->";
//            System.out.println(decoration + message);
//        };
//        printer.print("Hello World!");

        //(user) -> user.getAge();
    }
}
