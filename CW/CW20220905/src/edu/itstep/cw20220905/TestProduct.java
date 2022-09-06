package edu.itstep.cw20220905;

public class TestProduct {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product);
        System.out.println(product.getName());
        System.out.println(product.getPrice());

        Product product1 = new Product("phone", 100); // ctrl + P


    }

}
