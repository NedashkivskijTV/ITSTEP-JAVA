package org.example.ex5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class App {
    public static void main(String[] args)  {
        // MANY TO MANY
        // АСОЦІАЦІЇ - bi-directional association - двосноронній зв'язок

        SessionFactory factory = new Configuration()
                .configure("hibernate4.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД (<property name="connection.url">jdbc:mysql://localhost:3306/my_db_4</property>)
                .addAnnotatedClass(Child.class) // передаються сутності (Entity)
                .addAnnotatedClass(Section.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // CREATE ---------------------
        // створення секцій
//        Section english = new Section("English", 2700);
//        Section karate = new Section("Karate", 350);
//        Section music = new Section("Music", 120);

        // створення об'єктів Child
//        Child ivan = new Child("Ivan", "Ivanenko", 8);
//        Child petro = new Child("Petro", "Petrenko", 7);
//        Child olga = new Child("Olga", "Ivanova", 6);
//        Child artem = new Child("Artem", "Udov", 7);

        // Додавання об'єктів Child до секцій
//        english.addChild(ivan);
//        karate.addChild(ivan);
//        music.addChild(petro);
//        music.addChild(olga);

        // УВАГА ! - Збереження інф у БД - використання методу persist() - ОБОВ'ЯЗКОВЕ !!!
//        session.persist(english);
//        session.persist(karate);
//        session.persist(music);

        // Додавання секцій до об'єкту Child (усі об'єкти вже існують у БД)
//        Section english1 = session.get(Section.class, 1);
//        Section karate1 = session.get(Section.class, 2);
//        Child petro1 = session.get(Child.class, 2);
//        petro1.addSection(english1);
//        petro1.addSection(karate1);
//        //english1.addChild(petro1);
//        //karate1.addChild(petro1);


        // READ ---------------------
        Child petro_r = session.get(Child.class, 2);
        List<Section> sections = petro_r.getSections();
        sections.forEach(System.out::println);

        Section karate_r = session.get(Section.class, 2);
        List<Child> children =  karate_r.getChildren();
        children.forEach(System.out::println);


        // UPDATE ---------------------
//        Child olga_u = session.get(Child.class, 3);
//        olga.setLastName("Ivanenko");


        // DELETE ---------------------
//        Section music_d = session.get(Section.class, 6);
//        session.delete(music_d);

//        Child child = session.get(Child.class, 4);
//        session.delete(child);


        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки
    }
}
