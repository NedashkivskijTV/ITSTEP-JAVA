package edu.itstep.cw20221003_repeat.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main2 {
    public static void main(String[] args) {
        // Виклик приватних методів за межами класу

        User user = new User("Stepan", "Bandera");

        //user.privateMethod(); // помилка - метод приватний - може бути відкритий лише у межах класу

        // застосування рефлексії
        try {
            Method method = user.getClass().getDeclaredMethod("privateMethod", String.class, int.class);
            System.out.println(method.getName()); // отримання імені методу - необхідно для аспектно-орієнтованого програмування
            int modifier = method.getModifiers(); // повертає значення інт, щодо модифікатора доступа
            System.out.println(Modifier.isPrivate(modifier)); // конструкція для перевірки чи є модифікаатор доступа приватним
            System.out.println(method.getReturnType()); // повертає тип поверненого значення у метода
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
