package com.google.accounting.repository;

import com.google.accounting.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    private SessionFactory sessionFactory;

    @Override
    //@Transactional // анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен org.springframework.transaction.annotation.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession(); // отримання сесії (відкриття та закриття сесії здійснюватиме бін HibernateTransactionManager (описаний у applicationContext.xml) для підключення якого потрібно додати до методу аномацію @Transactional)
        Query<Employee> query = session.createQuery("from Employee", Employee.class); // запит на отримання усіх даних з таблиці - Query<Employee>-спеціальний об'єкт для створення запиту
        List<Employee> employees = query.getResultList(); // директива на отримання результатів запиту

        return employees;

        //return session.createQuery("from Employee", Employee.class).getResultList(); // те ж саме в один рядок

//        // компактна реалізація методу
//        return sessionFactory
//                .getCurrentSession()
//                .createQuery("from com.google.accounting.entity.Employee", Employee.class)
//                .getResultList();
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
                .createQuery("delete from Employee where id = " + id)
                .executeUpdate();
    }

    @Override
    public Employee getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Employee.class, id);
    }
}
