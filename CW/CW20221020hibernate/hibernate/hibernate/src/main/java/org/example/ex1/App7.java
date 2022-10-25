package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App7 {
    public static void main(String[] args) {
        //READ
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee where department = 'DEVELOPER'").getResultList();//HQL
        employees.forEach(System.out::println);
        session.getTransaction().commit();
    }
}
//Добавить взаимодействие с пользователем через консоль
//1.Показать всех
//2.Добавить нового
//3.Удалить по id
//4*.Изменить по id