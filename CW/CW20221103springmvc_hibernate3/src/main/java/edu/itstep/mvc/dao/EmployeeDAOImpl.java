package edu.itstep.mvc.dao;

import edu.itstep.mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // вказує на конкретну сутність яка взаємодіє з БД
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    private SessionFactory sessionFactory; // впровадження біна SessionFactory за допомогою DI

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен org.springframework.transaction.annotation.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession(); // отримання сесії (відкриття та закриття сесії здійснюватиме бін HibernateTransactionManager (описаний у applicationContext.xml) для підключення якого потрібно додати до методу аномацію @Transactional)

        Query<Employee> query =  session.createQuery("from Employee", Employee.class); // запит на отримання усіх даних з таблиці - Query<Employee>-спеціальний об'єкт для створення запиту
        List<Employee> employees = query.getResultList(); // директива на отримання результатів запиту

        return employees;

        //return session.createQuery("from Employee", Employee.class).getResultList(); // те ж саме в один рядок
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен org.springframework.transaction.annotation.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public void SaveOrUpdate(Employee employee) {
        System.out.println(employee);
        sessionFactory.getCurrentSession().saveOrUpdate(employee); // застосовується метод, що виконується в залежності від наявності у об'єкта Employee ідентифікатора id (якщо є - оновлює дані, якщо немає - додає)
//        if(employee.getId() == 0){
//            sessionFactory.getCurrentSession().save(employee);
//        } else {
//            sessionFactory.getCurrentSession().update(employee);
//        }
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен org.springframework.transaction.annotation.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Employee where id = " + id).executeUpdate();
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен org.springframework.transaction.annotation.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public Employee getById(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }
}
