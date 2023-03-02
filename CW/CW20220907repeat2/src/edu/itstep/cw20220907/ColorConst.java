package edu.itstep.cw20220907;

public class ColorConst { // Shift + F6  - переіменувати клас + файл

    public static  final String RED = "red"; // змінна класу
    public static  final String GREEN = "green"; // змінна класу
    public static  final String BLACK = "black"; // змінна класу

    // створення пустого конструктора (заміна створюваного за замовчуванням конструктора)
    // та закриття його модифікатором доступу з метою унеможливлення
    // створення ззовні екземплярів класу
    private ColorConst() {
    }
}
