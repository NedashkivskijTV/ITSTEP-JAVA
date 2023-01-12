package com.google.rest.repository;

import com.google.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // – вказує на конкретний клас, який взаємодіятиме з БД
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    private SessionFactory sessionFactory; // впровадження залежність SessionFactory За допомогою DI & IoC (створюється фреймворком – створено відповідний бін, але потрібно впровадити) – додати відповідне поле класу до якого додати анотацію @Autowired

    @Override
    public List<Employee> getAll() {
//        Session session = sessionFactory.getCurrentSession(); // отримання сесії (відкриття та закриття сесії здійснюватиме бін HibernateTransactionManager (описаний у applicationContext.xml) для підключення якого потрібно додати до методу аномацію @Transactional)
//        Query<Employee> query = session.createQuery("from Employee", Employee.class); // запит на отримання усіх даних з таблиці - Query<Employee>-спеціальний об'єкт для створення запиту
//        List<Employee> employees = query.getResultList(); // директива на отримання результатів запиту
//        return employees;

        // компактна реалізація методу
        return sessionFactory
                .getCurrentSession() // отримання сесії (відкриття та закриття сесії здійснюватиме бін HibernateTransactionManager (описаний у applicationContext.xml) для підключення якого потрібно додати до методу аномацію @Transactional)
                .createQuery("from com.google.rest.entity.Employee", Employee.class) // запит на отримання усіх даних з таблиці - Query<Employee>-спеціальний об'єкт для створення запиту
                .getResultList(); // директива на отримання результатів запиту у вигляді списку
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        System.out.println(employee);
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(employee); // метод, що забезпечує збереження або оновлення даних у БД в залежності від наявності у об'єкта поля id - якщо ідентифікатор присутніій, значить об'єкт вже існує у БД та потрібно його оновити
    }

    @Override
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from com.google.rest.entity.Employee where id = " + id)
                .executeUpdate();
    }

    @Override
    public Employee getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Employee.class, id);
    }
}
