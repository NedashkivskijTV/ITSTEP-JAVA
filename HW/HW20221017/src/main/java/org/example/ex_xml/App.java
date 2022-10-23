package org.example.ex_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "\nКонфігурування configuration file за допомогою XML\n" );
        // При створенні та наповненні об'єкта Address використовується конструктор з параметрами
        // При створенні об'єкта User використовується конструктор за замовчуванням
        // для реалізації DI використовується сетер
        // для наповнення об'єкта даними з файлу - сетери

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_xml.xml");

//        Address address = context.getBean("address", Address.class);
//        System.out.println(address);
//        System.out.println("street - " + address.getStreet());

        User user = context.getBean("user", User.class);
        System.out.println(user);
        System.out.println("user street - " + user.getAddress().getStreet());

        context.close();
    }
}
