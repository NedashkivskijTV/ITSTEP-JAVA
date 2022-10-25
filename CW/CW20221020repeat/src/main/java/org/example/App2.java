package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity) - в даному разі 1 - Employee
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // життєвий цикл сесії невеликий - створюється для здійснення запиту, після вдповіді - закривається

        session.beginTransaction();

        // Отримання групи об’єктів
        //List<Employee> employees = session.createQuery("from Employee").getResultList(); // HQL - приймає рядок формату HQL (від Hibernate) - схожий на урізаний SQL
        // в параметрах Employee підсвічує червоним - не помилка - компілятор не розуміє що це за сутність - працює коректно

        //List<Employee> employees = session.createQuery("from org.example.entity.Employee").getResultList(); // HQL - приймає рядок формату HQL (від Hibernate) - схожий на урізаний SQL
        // для відображення параметрів без червоного підсвічування - вказати повне ім'я класу

        List<Employee> employees = session.createQuery("from Employee").getResultList(); // HQL - приймає рядок формату HQL (від Hibernate) - схожий на урізаний SQL
        // в параметрах вказується назва класу, об'єкт якого потрібно витягнути з таблиці (таблиця визначається за анотаціями класу) або таблиця
        // для відображення параметрів без червоного підсвічування - вказати сам клас або папку з класами - сутностями як бібліотеку -
        // обрати на панелі інструментів File – Project Structure - У вікні Project Structure – обрати Libraries
        // – середнє вікно обрати «+» – у випадаючому вікні обрати Java -
        // У навігаційному вікні звернутись до папки, де зберігаються сутності, натиснути ОК

        employees.forEach(System.out::println);

        session.getTransaction().commit(); // знімок - збереження в БД раніше зроблених змін ,   навіть у разі виникнення помилки

    }
}
