package org.example.ex1.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App5 {
    public static void main(String[] args) {
        //UPDATE
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        session.createQuery("update Employee set salary = 200").executeUpdate();

        session.getTransaction().commit();
    }
}
