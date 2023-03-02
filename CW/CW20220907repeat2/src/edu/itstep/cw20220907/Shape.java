package edu.itstep.cw20220907;

/**
 * Абстрактний клас - клас, екземпляр якого створити неможливо,
 * містить принаймі 1 абстрактний метод
 *
 * Абстрактний метод - метод без реалізації, лише прототип
 *
 * Java дозволяє створити абстактний клас без абстрактних методів, але сенсу
 * така сутність не матиме. Як варіант такий клас можна створити для
 * заборони створення екземпляра, однак це можна реалізувати простоим створенням
 * приватного конструктора (який замінить конструктор, створюваний за замовчуванням)
 */
public abstract class Shape { // extends Object
//    private String backgroundColor;
//    private String borderColor;

    protected String backgroundColor;
    protected String borderColor;

//    public Shape() {
//    }

    public Shape(String backgroundColor, String borderColor) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void print(){
        //System.out.println("I am figure " + backgroundColor + " " + borderColor); // виведення з переходом на наступний рядок
        System.out.println("I am figure " + backgroundColor + " " + borderColor);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "backgroundColor='" + backgroundColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                '}';
    }

//    public  double calcArea(){
//        //return 0; //заглушка
//    }

    public abstract double calcArea();
}
