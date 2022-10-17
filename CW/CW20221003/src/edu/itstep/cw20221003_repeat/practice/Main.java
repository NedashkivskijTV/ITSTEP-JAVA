package edu.itstep.cw20221003_repeat.practice;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        // Практичне завдання - спільне використанні Анотацій та Рефлексії
        // - створити метод, який буде друкувати інф про об'єкт, але що саме
        // друкуватиметься визначатиме власноруч створена анотація

        User user = new User("Ivan", "Ivanenko", "7777777", "iimail@gmail.com");
        print(user);
    }

    public static void print(Object object) {
        Field[] fields = object.getClass().getDeclaredFields(); // отримання доступу до усіх оголошених полів
        for (Field field : fields) { // перебір отриманих полів
            field.setAccessible(true); // дозвіл на використання приватних полів
            AllowPrint allowPrint = field.getAnnotation(AllowPrint.class); // створення змінної типу анотації
            // - для отримання посилання на анотацію кожного поля
            // при відсутності вказаного типу агнотації - повертає null
            if (allowPrint != null && allowPrint.value() == true) { // перевірка наявності анотації визначеного типу,
                // а також значення її параметра - має бути true
                try {
                    System.out.println(field.getName() + " = " + field.get(object)); // виведення імені поля та його вмісту
                    // метод .get потребує обгортання у try-catch блок
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
