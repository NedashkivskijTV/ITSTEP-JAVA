package org.example.ex4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // ONE TO MANY

        SessionFactory factory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // CREATE
//        Department department1 = new Department("DEVELOPER", 300, 5000);
//        session.save(department1);

        Department department2 = new Department("DESIGNER", 300, 5000);
        Employee employee1 = new Employee("Ivan", "Ivanenko", 3000);
        Employee employee2 = new Employee("Petro", "Petrenko", 3100);
        department2.addEmployee(employee1);
        department2.addEmployee(employee2);

        session.save(department2);

        //READ

        // UPDATE

        // DELETE


        session.getTransaction().commit();
    }
}
