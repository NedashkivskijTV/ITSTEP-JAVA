package edu.itstep.cw20220915.enums;

public class MainOperation {
    public static void main(String[] args) {
        Operation op = Operation.SUM;
        System.out.println(op.action(10.1, 4.2)); // 14.3

        System.out.println(Operation.MULTIPLY.action(7, 5)); // 35.0

        op = Operation.SUBTRACT;
        System.out.println(op.action(77.7, 11.7)); // 66.0

        op = Operation.DIVISION;
        System.out.println(op.action(100.0, 4)); // 25.0
    }
}
