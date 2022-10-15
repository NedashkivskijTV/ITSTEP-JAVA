package edu.itstep.cw20221003_repeat.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        User u; // змінна, щоб покласти туди посилання на об'єкти класа User

        Class c; // змінна, щоб покласти туди посилання на об'єкти класа Class
        // У Java клас/тип Class - створений для надання доступу до всього, що є в якомусь класі

        // Створення екземпляра класу Class
        // 1 - використання статичного методу .forName()
        try {
            Class<?> class1 = Class.forName("edu.itstep.cw20221003_repeat.reflection.User"); // отримується об'єкт котрий буде давати
                                                              // доступ до всього наповнення класу User
            // якщо у параметрах методу forName() вказується "User" - пошук класу здійснюватиметься у каталозі src
            // для пошуку в іншому розташуванні вказується шлях від src
            // Class<?> - подібна типізація вказує на те, що у змінній може лежати посилання на будь-що
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 2 - через метод екземпляра класу .getClass() - метод насліжується від класу Object
        User user = new User("Ivan", "Ivanenko");
        Class<? extends User> class2 = user.getClass();
        // Тип змінної class2 - означає, що до неї може бути збережено посилання на клас User,
        // або класи, що є його спадкоємцями

        // 3 - з використанням властивості .class (має кожний тип даних, як примітиви так і ссилочні).
        // При цьому звертання відбувається не до змінної, а до самого типу даних
        // У даний об'єкт може бути поміщене лише посилання на клас User - жорстка типізація
        // Викортстовується найчастіше
        Class<User> class3 = User.class;

        // -------------------------------------------------------------------------------------------------------------
        // Отримання інформації з екземпляра класу Class
        Class<User> userClass = User.class;

        // Отримання методів
        // getMethods() - надає доступ (назва методів та сигнатури) до усіх публічних методів класу, в т.ч. тих, що наслідуються
        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-------------------------------------------------------------");

        // getDeclaredMethods() - надає доступ (назва методів та сигнатури) до усіх оголошених методів у класі не зважаючи на модифікатори доступу (без спадкоємців)
        Method[] methods1 = userClass.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("-------------------------------------------------------------");

        // Отримання доступу до полів - змінних екземпляра
        // getFields() - доступ до усіх публічних полів класу та унаслідуваних
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-------------------------------------------------------------");

        // getDeclaredFields() - доступ до усіх оголошених в класі полів, без урахування модифікатора доступу
        Field[] fields1 = userClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName()); // getName() - отримання лише імені поля чи методу
            System.out.println(field.getType()); // getType() - отримання лише типів даних
            System.out.println(field.getType().getSimpleName()); // getType().getSimpleName() - отримання лише назви типу без шляху розташування
            System.out.println(field);
        }
        System.out.println("-------------------------------------------------------------");


        // Отриманя доступу до конкретного метода
        // getMethod("methodName", Class<?>... тип параметрів) - доступ до усіх публічних методів, в т.ч. унаслідуваних
        //Method method1 = userClass.getMethod("methodName");
        //System.out.println("-------------------------------------------------------------");

        // getDeclaredMethod("methodName", Class<?>... тип параметрів) - доступ до усіх, оголошених у класі методів
        try {
            Method method1 = userClass.getDeclaredMethod("privateMethod"); // звернення до методу без параметрів
            System.out.println(method1);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {
            Method method2 = userClass.getDeclaredMethod("privateMethod", String.class, int.class); // звернення до методу з параметрами
            System.out.println(method2);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------------");


        // Отримання доступу до конструкторів
        // getDeclaredConstructors() - надає доступ до усіх оголошених у класі конструкторів
        Constructor[] constructors = userClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------------------------------------");


    }
}
