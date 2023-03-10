package edu.mywork.ProductStore.Models;

public enum Color {
    BLACK("black", "чорний"),
    WHITE("white" , "білий"),
    RED("red", "червоний"),
    ORANGE("orange", "помаранчевий"),
    YELLOW("yellow", "жовтий"),
    GREEN("green", "зелений"),
    BLUE("blue", "блакитний"),
    NAVYBLUE("navyblue", "синій"),
    VIOLET("violet", "фіолетовий"),
    STEEL("steel", "сталевий"),
    GREY("grey", "сірий"),
    SILVER("silver", "срібний");

    private final String colorNameEn;
    private final String colorNameUa;

    Color(String colorNameEn, String colorNameUa) {
        this.colorNameEn = colorNameEn;
        this.colorNameUa = colorNameUa;
    }

    public String getColorNameEn() {
        return colorNameEn;
    }

    public String getColorNameUa() {
        return colorNameUa;
    }
}
