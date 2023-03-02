package edu.itstep.cw20220907;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(String backgroundColor, String borderColor, double width, double height) {
        super(backgroundColor, borderColor); // виклик батьківського конструктора (у перевизначеному методі - виклик батьківського методу)
        this.width = width;
        this.height = height;
    }

//    public Rectangle(double width, double height){
//        super(ColorConst.BLACK, ColorConst.BLACK);
//        this.width = width;
//        this.height = height;
//    }

    public Rectangle(double width,  double height){
        this(ColorConst.BLACK, ColorConst.BLACK, width, height); // посилання через this на інший конструктор (з іншим набором параметрів)
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //ctrl + O
    @Override // анотація -відслідковує доступні для перевизначення методів батьківського класу- допомога для розробника, не зачіпає функціонал
    public void print() {
        //super.print(); // батьківський функціонал можна видалити
        //System.out.println(" " + width + " " + height);
        //System.out.println("I am Rectangle " + getBackgroundColor() + " " + getBorderColor() + " " + width + " " + height);
        System.out.println("I am Rectangle " + backgroundColor + " " + borderColor + " " + width + " " + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString(); // виклик методу батьківського класу (для перевизначеного методу)
    }

    @Override
    public double calcArea() {
        return width * height;
    }
}
