package org.example.ex3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // ONE NO ONE
        // АСОЦІАЦІЇ - bi-directional association - двосторонній зв'язок (отримати інф з Employee про Detail можна,
        // від Detail про Employee - також)

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД (<property name="connection.url">jdbc:mysql://localhost:3306/my_db_2</property>)
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity)
                .addAnnotatedClass(Detail.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // CREATE ---------------------
        Employee employee = new Employee("Petr", "Petrov", "DEVELOPER"); // створення об'єкта Employee
        Detail detail = new Detail("petrov@gmail.com", "+380-67-222-22-22"); // створення об'єкта Detail
        detail.setEmployee(employee); // встановлення зв'язка між Detail та Employee
        employee.setDetail(detail); //встановлення зв'язка між Employee та Detail (інакше полу із вториним ключем у БД залишиться пустим та інф не буде пов'язана)

        session.save(detail); // директива на збереження об'єкта Detail (із пов'язаними з ним даними) до БД


        // READ ---------------------
        // отримання Detail за id
        Detail detail_r = session.get(Detail.class, 17); // отримання інф про Detail за id
        System.out.println(detail_r.getPhone()); // виведення інф про телефон
        System.out.println(detail_r.getEmployee().getFirstName()); // отримання інф з Detail про Employee та її виведення

        //отримання колекції елементів Detail
        List<Detail> detailList = session.createQuery("from Detail").getResultList();
        for (Detail detail_read : detailList) {
            System.out.print(detail_read + " - ");
            System.out.println(detail_read.getEmployee().getFirstName());
        }


        // UPDATE ---------------------
        // працює аналогічно попередньому прикладу
//        // 1 - при наявності об'єкта Employee
//        Employee employee2 = session.get(Employee.class, 7); // отримання інф про Employee за id
//        employee2.setDepartment("HR");
//        employee2.getDetail().setPhone("+380-50-888-87-87");
//        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД
//        session.createQuery("update Employee set lastName = 'Antonov' where firstName='Anton'").executeUpdate();


        // DELETE ---------------------
        // 1 - при наявності об'єкта Employee
        Employee employee16 = session.get(Employee.class, 16);
        Detail detail17 = session.get(Detail.class, 17);
        session.delete(employee16); // видалення інф про Employee та каскадне видалення пов'язаної з ним Detail
        session.delete(detail17); // видалення інф про Detail та каскадне видалення пов'язаної з ним Employee
//        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД
//        session.createQuery("delete Employee where firstName = 'Anton'").executeUpdate();

        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки

    }
}
