package edu.itstep.cw20221003_repeat.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main3 {
    public static void main(String[] args) {

        // Виклик приватного конструктора - через клас Constructor

        try {
            Constructor constructor = User.class.getDeclaredConstructor(String.class); // отримання посилання на конструктор
            // через посилання на об'єкт класу в якого (у класу) викликається метод getDeclaredConstructor
            // - приймає аргумент змінної довжини - параметри потрібного конструктора
            // генерує виключну ситуацію, потребує обгортання у try-catch блок

            constructor.setAccessible(true); // .setAccessible(true) - надання дозволу на доступ до приватного конструктора

            constructor.newInstance("Taras"); // .newInstance("Taras") - команда на виклик конструктора
            // - приймає параметри потрібного конструктора
            // - метод повертає створений конструктором об'єкт у вигляді екземпдяра Object
            //User user = constructor.newInstance("Taras"); // ПОМИЛКА !!!

            // - для того, щоб присвоїти його змінній відповідного типу потрібно застосувати явне приведення типів
            // Alt + Enter -> Cast
            User user = (User) constructor.newInstance("Taras"); // екземпляр класу User створено
            // генерує виключну ситуацію, потребує обгортання у try-catch блок (додати catch)

            System.out.println(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
