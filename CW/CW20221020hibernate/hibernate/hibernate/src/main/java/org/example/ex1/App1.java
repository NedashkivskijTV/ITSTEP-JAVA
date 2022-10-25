package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App1 {
    public static void main(String[] args) {
        //READ
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        //Employee employee = session.get(Employee.class, 2);
        Employee employee = session.get(Employee.class, 3);
        System.out.println(employee);
        session.getTransaction().commit();
    }
}
