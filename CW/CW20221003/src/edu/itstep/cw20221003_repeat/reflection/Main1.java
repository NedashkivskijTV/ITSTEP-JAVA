package edu.itstep.cw20221003_repeat.reflection;

import java.lang.reflect.Field;

public class Main1 {
    public static void main(String[] args) {
        // Доступ до приватних полів
        // getDeclaredField("firstName") - Отримання загальної інф (тип, модифікатор доступу)
        // setAccessible(true) - метод, що надає дозвіл на доступ до приватних полів
        // .set(user, "Andriy"); // метод, що дозволяє змінювати значення поля (навіть приватного)

        User user = new User("Stepan", "Bandera");
        //System.out.println(user.firstName); // помилка - поле приватне

        Class<? extends User> userClass = user.getClass();

        try {
            Field field = userClass.getDeclaredField("firstName"); // Отримання загальної інф (тип, модифікатор доступу)
            field.setAccessible(true); // метод, що надає дозвіл на доступ до приватних полів
            System.out.println(field.get(user));
            field.set(user, "Andriy"); // метод, що дозволяє змінювати значення поля (навіть приватного)
            System.out.println(field.get(user));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
