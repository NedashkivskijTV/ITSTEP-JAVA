package edu.itstep.cw20220915.enums;

public enum Color {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00");

    private String hex; // інформація, що міститтиметься у кожному екземплярі enum
    //public final String inf; // аріант оголошення змінної екземпляра enum

    Color(String hex) {
        this.hex = hex;
    } // конструктор

    // доступне створення необмеженої кількості методів
    public String getHex() {
        return hex;
    }

}
