package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App2 {
    public static void main(String[] args) {
        //READ
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Employee>employees = session.createQuery("from Employee").getResultList();//HQL
        employees.forEach(System.out::println);
        session.getTransaction().commit();
    }
}
