package edu.itstep.cw20220905;

public class Product {
    // змінні екземпляра
    private String name = "no name";//null
    private int price;//0

    //alt + insert або ПКМ - Generate --- виклик меню для генерації сіщностей (конструктор, get, set)

    public Product() {
//        System.out.println("constructor: " + this);
//        System.out.println(name);
//        System.out.println(price);
    }
    public Product(String name, int price) {
        this.name = name; // this.name - звертання до змінної екземпляра
        this.price = price; // this - ключове слово
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        System.err.println("ERROR!"); // виводить текст у консоль ЧЕРВОНОГО кольору
        this.price = price;
    }
}
