package org.example.ex2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // ONE TO ONE
        // uni directional

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // CREATE
//        Employee employee = new Employee("Ivan", "Ivanenko", "DEVELOPER");
//        Detail detail = new Detail("ivanenko@gmail.com", "077-777-77-77");
//        Employee employee = new Employee("Semen", "Semenenko", "DEVELOPER");
//        Detail detail = new Detail("semenenko@gmail.com", "011-111-11-11");
//        Employee employee = new Employee("Petro", "Petrenko", "DEVELOPER");
//        Detail detail = new Detail("petro@gmail.com", "088-888-88-88");
//        employee.setDetail(detail);
//        session.save(employee);

         //READ
//        Employee employee = session.get(Employee.class, 1);
//        System.out.println(employee.getFirstName());
//        System.out.println(employee.getDetail().getPhone());

        // UPDATE
//        Employee employee = session.get(Employee.class, 1);
//        employee.setFirstName("Oleg");
//        employee.setLastName("Olegov");
//        employee.setDepartment("DESIGNER");
//        employee.getDetail().setPhone("055-555-55-55");

        // DELETE
        Employee employee = session.get(Employee.class, 1);
        session.delete(employee);


        session.getTransaction().commit();
    }
}
