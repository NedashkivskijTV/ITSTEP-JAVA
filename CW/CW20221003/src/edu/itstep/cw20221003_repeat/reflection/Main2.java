package edu.itstep.cw20221003_repeat.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main2 {
    public static void main(String[] args) {
        // Виклик приватних методів за межами класу

        User user = new User("Stepan", "Bandera");

        //user.privateMethod(); // помилка - метод приватний - може бути відкритий лише у межах класу

        // застосування рефлексії
        try {
            Method method = user.getClass().getDeclaredMethod("privateMethod", String.class, int.class); // виткористовується ланцюжок викликів
            // - з екземпляра user витягується інф щодо класу (отримується посилання на об'єкт класу Class),
            // та потім в ньому викликається метод getDeclaredMethod (це метод об'їкта типу Class),
            // в параметрах вказуються назва потрібного методу та його параметри

            System.out.println(method.getName()); // method.getName() - отримання імені методу - необхідно для аспектно-орієнтованого програмування

            int modifier = method.getModifiers(); // method.getModifiers() - повертає значення int (набір констант), щодо модифікатора доступа
            System.out.println(Modifier.isPrivate(modifier)); // Modifier.isPrivate(modifier) - конструкція для перевірки чи є модифікатор доступа приватним

            System.out.println(method.getReturnType()); // method.getReturnType() - повертає тип поверненого значення у метода
            System.out.println("----------------------------------------------------------");

            // Виклик методу - ПРИВАТНОГО
            method.setAccessible(true); // надання доступу до приватного методу

            // invoke(user, "2", 2) - виклик методу, в т.ч. приватного
            // - приймає назву об'єкта в класі якого викликається метод та
            // аргумент змінної довжини - параметри методу, що викликаються
            // генерує виключну ситуацію, потребує обгортання у try-catch блок
            method.invoke(user, "2", 2);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
