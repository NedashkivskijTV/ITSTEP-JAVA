package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity) - в даному разі 1 - Employee
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // життєвий цикл сесії невеликий - створюється для здійснення запиту, після вдповіді - закривається

        session.beginTransaction();

        // Отримання групи об’єктів

        List<Employee> employees = session.createQuery("from Employee where department = 'DEVELOPER'").getResultList(); // HQL - приймає рядок формату HQL (від Hibernate) - схожий на урізаний SQL
        //List<Employee> employees = session.createQuery("from Employee where department = 'DEVELOPER' or department = 'HR'").getResultList(); // HQL - приймає рядок формату HQL (від Hibernate) - схожий на урізаний SQL
        //List<Employee> employees = session.createQuery("from Employee where department = 'DEVELOPER' and firstName = 'Oleg'").getResultList(); // HQL - приймає рядок формату HQL (від Hibernate) - схожий на урізаний SQL
        employees.forEach(System.out::println);

        session.getTransaction().commit(); // знімок - збереження в БД раніше зроблених змін ,   навіть у разі виникнення помилки

    }
}
