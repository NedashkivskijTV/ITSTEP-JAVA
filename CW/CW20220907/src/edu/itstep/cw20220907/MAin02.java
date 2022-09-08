package edu.itstep.cw20220907;

public class MAin02 {
    public static void main(String[] args) {
        test(1);
        test(1, 2);
        test(1, 2.0);

        System.out.println("1" + 1);
        System.out.println(1 + 1);
    }
    public static void test(int i) {
        System.out.println("test1");
    }

    public static void test(int i, int j) {
        System.out.println("test2");
    }

    public static void test(int i, double j) {
        System.out.println("test3");
    }

}
