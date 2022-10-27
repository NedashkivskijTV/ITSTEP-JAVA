package org.example.ex4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // ONE TO MANY
        // АСОЦІАЦІЇ - bi-directional association - односноронній зв'язок (отримати інф з employees про departments можна,
        // від departments про конкретного employees - ні, тільки колекцію employees)

        SessionFactory factory = new Configuration()
                .configure("hibernate3.cfg.xml") // конфігураційний файл, де вказано налаштування доступу до БД (<property name="connection.url">jdbc:mysql://localhost:3306/my_db_3</property>)
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity)
                .addAnnotatedClass(Department.class) // передаються сутності (Entity)
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // створення сесії

        session.beginTransaction(); // відкриття сесії

        // CREATE ---------------------
        // Додавання пустого департамента
//        Department department1 = new Department("DEVELOPER", 1000, 5000);
//        session.save(department1);

        // Додавання департамента з працівниками
        Department department2 = new Department("DESIGNER", 1000, 5000);
        Employee employee1 = new Employee("Ivan", "Ivanenko", 2000);
        Employee employee2 = new Employee("Petro", "Petrenko", 2500);
        department2.addEmployee(employee1);
        department2.addEmployee(employee2);
        session.save(department2);

        // Додавання працівників до раніше створеного департаменту, при наявності доступу до об'єкта - даного департаменту
        Department department3 = session.get(Department.class, 1); // отримання об'єкта Департамент за id
        Employee employee31 = new Employee("Oleg", "Olegov", 400);
        Employee employee32 = new Employee("Sergiy", "Sergienko", 3000);
        department3.addEmployee(employee31);
        department3.addEmployee(employee32);


        // READ ---------------------
        // отримання Department за id
//        Department department4 = session.get(Department.class, 1); // отримання об'єкта Департамент за id
        //отримання колекції елементів Employee
//        for (Employee employee : department4.getEmployees()) {
//            System.out.println(employee);
//        }


        // UPDATE ---------------------
        // 1 - при наявності об'єкта Employee
//        Employee employee_u = session.get(Employee.class, 3);
//        employee_u.setFirstName("Sirozhko");

        // зміна зарплати усім розробникам на +100
//        Department department_u = session.get(Department.class, 1); // отримання об'єкта Департамент за id
//        department_u.getEmployees().forEach((e) -> e.setPrice(e.getPrice() + 100));

//        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД


        // DELETE ---------------------
        // 1 - при наявності об'єкта Employee
//        Employee employee_d = session.get(Employee.class, 3);
//        session.delete(employee_d); // видалення особи

        // 2 - Використання HQL - змінну витягати не потрібно - зміни вівдбудуться одразу в БД
//        Department department_d = session.get(Department.class, 2);
//        session.delete(department_d); // видалення департамента з каскадним видаленням усіх пов'язаних працівників

        session.getTransaction().commit(); // закриття сесії - знімок - збереження в БД раніше зроблених змін , навіть у разі виникнення помилки

    }
}
