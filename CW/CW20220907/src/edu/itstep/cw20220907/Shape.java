package edu.itstep.cw20220907;

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

    public String getBorderColor() {
        return borderColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void print(){
        //System.out.println("I am figure " + backgroundColor + " " + borderColor);
        System.out.print("I am figure " + backgroundColor + " " + borderColor);
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
