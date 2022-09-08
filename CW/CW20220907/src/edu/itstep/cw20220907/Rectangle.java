package edu.itstep.cw20220907;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String backgroundColor, String borderColor, double width, double height) {
        super(backgroundColor, borderColor);
        this.width = width;
        this.height = height;
    }

//    public Rectangle(double width, double height){
//        super(ColorConst.BLACK, ColorConst.BLACK);
//        this.width = width;
//        this.height = height;
//    }
    public Rectangle(double width, double height){
        this(ColorConst.BLACK, ColorConst.BLACK, width, height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
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
                "} " + super.toString();
    }

    @Override
    public double calcArea() {
        return height * width;
    }
}
