package edu.itstep.cw20220907;

public class Circle extends Shape {
    private double radius;


//    public Circle(){
//        super();
//    }

//    public Circle(String backgroundColor, String borderColor) {
//        super(backgroundColor, borderColor);
//    }

    public Circle(String backgroundColor, String borderColor, double radius) {
        super(backgroundColor, borderColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                "} " + super.toString();
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
