package edu.itstep.cw20220912_rozbir.lambda;

public class Main {
    public static void main(String[] args) {
//        Calculator sum = (x, y) -> x + y;
//        double result = sum.execute(2, 2);

        // використанні стандартного інтерфейса при створенні лямбди
/*
        Printer printer = message -> System.out.println("MESSAGE: " + message);
        printer.print("Hello");
*/

        Modificator modificator = (user) -> user.getAge();
    }

    public static void calculator(){
        Calculator division = (x, y) -> {
            if(y == 0){
                System.out.println("На 0 ділити не можна");
                return 0;
            }
            return x / y;
        };
    }
}
