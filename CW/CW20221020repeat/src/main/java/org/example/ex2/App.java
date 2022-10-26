package org.example.ex2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // ONE NO ONE
        // АСОЦІАЦІЇ - uni directional association - односноронній зв'язок (отримати інф з Employee про Detail можна,
        // від Detail про Employee - ні)

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД (<property name="connection.url">jdbc:mysql://localhost:3306/my_db_2</property>)
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity)
                .addAnnotatedClass(Detail.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // CREATE ---------------------
        Employee employee = new Employee("Anton", "Antonenko", "DESIGNER"); // створення об'єкта Employee
        Detail detail = new Detail("antonenko@gmail.com", "+380-97-977-97-97"); // створення об'єкта Detail
        employee.setDetail(detail); // встановлення зв'язка між Employee та Detail

        session.save(employee); // директива на збереження об'єкта employee (із пов'язаними з ним даними) до БД


        // READ ---------------------
        // отримання Employee за id
        Employee employee1 = session.get(Employee.class, 7); // отримання інф про Employee за id
        System.out.println(employee1.getFirstName()); // виедення інф про Employee
        System.out.println(employee1.getDetail().getPhone()); // отримання інф з Employee про Detail та її виведення

        //отримання колекції елементів Employee
        List<Employee> employees1 = session.createQuery("from Employee").getResultList();
        //employees1.forEach(System.out::println);
        for (Employee employee_1 : employees1) {
            System.out.print(employee_1);
            System.out.println(employee_1.getDetail());
        }


        // UPDATE ---------------------
        // 1 - при наявності об'єкта Employee
        Employee employee2 = session.get(Employee.class, 7); // отримання інф про Employee за id
        employee2.setDepartment("HR");
        employee2.getDetail().setPhone("+380-50-888-87-87");
        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД
        session.createQuery("update Employee set lastName = 'Antonov' where firstName='Anton'").executeUpdate();


        // DELETE ---------------------
        // 1 - при наявності об'єкта Employee
        Employee employee3 = session.get(Employee.class, 7);
        session.delete(employee3); // видалення інф про Employee та каскадне видалення пов'язаної з ним Detail
        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД
        session.createQuery("delete Employee where firstName = 'Anton'").executeUpdate();

        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки

    }
}
