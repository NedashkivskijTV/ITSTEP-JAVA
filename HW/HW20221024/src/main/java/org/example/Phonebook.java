package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Phonebook {

    private String[][] systemLines = new String[][]{
            new String[]{"yes", "no", "y", "n", ""},
            new String[]{"y", "yes", ""},
    };

    public void start() {
        System.out.println("Програма Телефонний довідник");
        System.out.println("Бажаєте розпочати роботу ? - " + stringMasToString(systemLines[0]));
        while (lineCheck(lineInputControl(""), systemLines[1])) { // "y", "yes", ""
            System.out.println("довідник");

            System.out.println("Бажаєте продовжити роботу? - " + stringMasToString(systemLines[0]));
        }
        System.out.println("Роботу програми завершено");
        //create();
        //read();
        //update();
        //delete();
    }

    private String lineInputControl(String message, String... correctLine) {
        if (message == null || message.length() == 0) {
            message = "Введіть yes/no та Enter";
        }
        if (correctLine == null || correctLine.length == 0) {
            correctLine = systemLines[0]; // "yes", "no", "y", "n", ""
        }
        Scanner scanner = new Scanner(System.in);
        String userLine = scanner.nextLine();
        while (!lineCheck(userLine, correctLine)) {
            System.out.println("\n" + message);
            userLine = scanner.nextLine();
        }
        return userLine;
    }

    private boolean lineCheck(String line, String... possibleLines) {
        for (String possibleLine : possibleLines) {
            if (possibleLine.equalsIgnoreCase(line)) {
                return true;
            }
        }
        return false;
    }

    private String stringMasToString(String... strings) {
        if (strings.length == 0) {
            return "";
        }
        StringBuffer strTemp = new StringBuffer("");
        for (String string : strings) {
            if(strTemp.length() != 0){
                strTemp.append(" ");
            }
            strTemp.append(string.length() == 0 ? "Enter" : string);
        }
        return strTemp.toString();
    }

    private void create() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД
                .addAnnotatedClass(Phone.class) // передаються сутності (Entity)
                .addAnnotatedClass(Contact.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // CREATE --------------------------------------------------------------------------------
        // Додавання пустого контакта
//        Contact contact_c1 = new Contact("Ivan", "Ivanenko");
//        session.save(contact_c1);

        // Додавання контакта з телефонами
//        Contact contact_c2 = new Contact("Anton", "Antonenko");
//        Phone phone_c1 = new Phone("+380-67-111-11-11");
//        Phone phone_c2 = new Phone("+380-67-222-22-22");
//        contact_c2.addPhone(phone_c1);
//        contact_c2.addPhone(phone_c2);
//        session.save(contact_c2);

        // Додавання телефонів до раніше створеного контакту, при наявності доступу до об'єкта - даного контакту
//        Contact contact_c3 = session.get(Contact.class, 1); // отримання контакту
//        Phone phone_c3 = new Phone("+380-97-333-33-33");
//        Phone phone_c4 = new Phone("+380-98-444-44-44");
//        contact_c3.addPhone(phone_c3);
//        contact_c3.addPhone(phone_c4);

//        Contact contact_c4 = session.get(Contact.class, 2);
//        Phone phone_c5= new Phone("+380-99-555-55-55");
//        contact_c4.addPhone(phone_c5);

        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки
    }

    private void read() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД
                .addAnnotatedClass(Phone.class) // передаються сутності (Entity)
                .addAnnotatedClass(Contact.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // READ --------------------------------------------------------------------------------------------------------
        // отримання Контакта за id
        Contact contact_r1 = session.get(Contact.class, 2);
        //отримання колекції телефонів
        List<Phone> phones = new ArrayList<>(contact_r1.getPhones());
        System.out.println(contact_r1);
        System.out.println(phones.get(0));
        //for (Phone phone : contact_r1.getPhones()) {
        for (Phone phone : phones) {
            System.out.println(phone);
        }

        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки
    }

    private void update() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД
                .addAnnotatedClass(Phone.class) // передаються сутності (Entity)
                .addAnnotatedClass(Contact.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // UPDATE ------------------------------------------------------------------------------------------------------
        // 1 - зміна об'єкта Contact при його наявності
//        Contact contact_u1 = session.get(Contact.class, 1);
//        contact_u1.setFirstName("Petro");
//        contact_u1.setLastName("Petrenko");

        // зміна телефона (першого у списку) контакта з id = 1
        Contact contact_u2 = session.get(Contact.class, 1); // отримання об'єкта за id
        Phone phone_u1 = contact_u2.getPhones().get(0);
        //System.out.println(phone_u1);
        phone_u1.setPhoneNumber("+380-77-777-77-77");
//        department_u.getEmployees().forEach((e) -> e.setPrice(e.getPrice() + 100));

//        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД


        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки
    }

    private void delete() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД
                .addAnnotatedClass(Phone.class) // передаються сутності (Entity)
                .addAnnotatedClass(Contact.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // DELETE ---------------------
        // 1 - видалення телефона при наявності об'єкта Phone
//        Phone phone_d1 =session.get(Phone.class, 4);
//        session.delete(phone_d1);

        // видалення контакта з каскадним видаленням усіх пов'язаних телефонів
        Contact contact_d1 = session.get(Contact.class, 2);
        //System.out.println(contact_d1);
        if (contact_d1 != null) { // перевірка результата отримання об'єкта з БД - якщо об'єкт вдсутній повернеться null
            session.delete(contact_d1);
        }

        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки
    }
}
