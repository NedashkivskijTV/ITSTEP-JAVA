package org.example.ex3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
//        Employee employee = new Employee("Oleg", "Olegov", "DEVELOPER");
//        Detail detail = new Detail("olegov@gmail.com", "055-555-55-55");
//        detail.setEmployee(employee);
//        employee.setDetail(detail);
//        session.save(employee);

         //READ
        Detail detail = session.get(Detail.class, 4);
        System.out.println(detail.getEmail());
        System.out.println(detail.getEmployee().getDepartment());

        // UPDATE
//        Employee employee = session.get(Employee.class, 1);
//        employee.setFirstName("Oleg");
//        employee.setLastName("Olegov");
//        employee.setDepartment("DESIGNER");
//        employee.getDetail().setPhone("055-555-55-55");

        // DELETE
//        Employee employee = session.get(Employee.class, 5);
//        Detail detail = session.get(Detail.class, 5);
//        session.delete(employee);
//        session.delete(detail);


        session.getTransaction().commit();
    }
}
