package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity) - в даному разі 1 - Employee
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // життєвий цикл сесії невеликий - створюється для здійснення запиту, після вдповіді - закривається

        session.beginTransaction();

        // Видалення елемента
        // 1 - при наявності елемента
        Employee employee = session.get(Employee.class, 1);
        session.delete(employee);

        // 2 - за допомогою HQL
        //session.createQuery("delete Employee where firstName = 'Petr'").executeUpdate();

        session.getTransaction().commit(); // знімок - збереження в БД раніше зроблених змін ,   навіть у разі виникнення помилки

    }
}
