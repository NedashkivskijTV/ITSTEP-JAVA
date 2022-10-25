package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //CREATE
        System.out.println("Hello World!");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Employee employee = new Employee("Petr", "Petrov", "HR", 300);
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

    }
}
