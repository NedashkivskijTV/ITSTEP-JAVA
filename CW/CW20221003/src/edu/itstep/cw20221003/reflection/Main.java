package edu.itstep.cw20221003.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //User u;
        //Class c;

        //System.out.println(u);
        //System.out.println(c);

        try {
            Class<?> class1 = Class.forName("edu.itstep.cw20221003.reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        User user = new User("Ivan", "Ivanov");
        Class<? extends User> class2 = user.getClass();

        Class<User> class3 = User.class;
        //System.out.println(int.class);

        Class<User> userClass = User.class;
//        Method[] methods = userClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

//        Class<User> userClass = User.class;
//        Method[] methods = userClass.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("------------------------------------------------------------------------------");
        try {
            Method method = userClass.getDeclaredMethod("privateMethod", String.class, int.class);
            System.out.println(method);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        System.out.println("------------------------------------------------------------------------------");
        Constructor[] constructors = userClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

    }
}
