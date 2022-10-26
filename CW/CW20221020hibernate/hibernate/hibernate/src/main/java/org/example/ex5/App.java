package org.example.ex5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate4.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // CREATE
//        Section english = new Section("English", 2700);
//        Section karate = new Section("Karate", 350);
//        Section music = new Section("Music", 120);
//
//        Child ivan = new Child("Ivan", "Ivanenko", 8);
//        Child petro = new Child("Petro", "Petrenko", 7);
//        Child olga = new Child("Olga", "Ivanova", 6);
//        Child artem = new Child("Artem", "Udov", 7);

//        english.addChild(ivan);
//        karate.addChild(ivan);
//
//        music.addChild(petro);
//
//        music.addChild(olga);
//
//        session.persist(english);
//        session.persist(karate);
//        session.persist(music);

//        Section english = session.get(Section.class, 1);
//        Section karate = session.get(Section.class, 2);
//        Child petro = session.get(Child.class, 2);
//        english.addChild(petro);
//        karate.addChild(petro);

        //READ
//        Child petro = session.get(Child.class, 2);
//        List<Section> sections = petro.getSections();
//        sections.forEach(System.out::println);
//
//        Section karate = session.get(Section.class, 2);
//        List<Child> children =  karate.getChildren();
//        children.forEach(System.out::println);

        // UPDATE


        // DELETE
        Section karate = session.get(Section.class, 2);
        session.delete(karate);


        session.getTransaction().commit();
    }
}
