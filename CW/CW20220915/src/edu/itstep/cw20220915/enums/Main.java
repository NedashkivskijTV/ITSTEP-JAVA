package edu.itstep.cw20220915.enums;

public class Main {
    public static void main(String[] args) {
        System.out.println(Color.RED);
        Color color = Color.BLUE;
        System.out.println(color);

        String st = Color.BLUE.toString(); // повертає назву обєкта enum у вигляді рядка
        System.out.println(st.toLowerCase());

        System.out.println(color.name()); // повертає назву обєкта enum у вигляді рядка
        System.out.println(color.ordinal()); // повертає порядковий номер екземпляра в колекції enum

        Color color1 = Color.valueOf("RED"); // повертає обєкт enum за назвою String
        System.out.println(color1);

        Color color11 = Color.values()[1]; //повертає колекцію обєктів enum - доступне звертання через [] та перебор

        Color color2 = Color.values()[1]; // повертає обєкт enum за порядковим номером в колекції
        System.out.println(color2);

        //доступний перебір колекції enum
        boolean hasColor = false;
        for (Color value : Color.values()) {
            if ("YELLOW".equals(value.toString())) {
                hasColor = true;
                break;
            }
        }
        System.out.println(hasColor);

        Color color3 = Color.RED;
        System.out.println(color3.getHex()); // отримання додаткової інф через геттер
    }
}
