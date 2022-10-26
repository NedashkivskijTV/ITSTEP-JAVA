package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity) - в даному разі 1 - Employee
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // життєвий цикл сесії невеликий - створюється для здійснення запиту, після вдповіді - закривається

        session.beginTransaction();

        // Зміна об'єкта
        // 1 - Об'єкт є в наявності (маємо боступ до існуючого у БД об'єкта)
        //Employee employee = session.get(Employee.class, 1);
        //employee.setSalary(7890); // після внесення змін та закриття сесії зміни буде застосовано

        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД
        //session.createQuery("update Employee set salary = 2000").executeUpdate(); // встановить однакові значення усім у БД
        session.createQuery("update Employee set salary = 2000 where id = '1'").executeUpdate(); // встановить значення елементу з id = 1

        session.getTransaction().commit(); // знімок - збереження в БД раніше зроблених змін ,   навіть у разі виникнення помилки
    }
}
