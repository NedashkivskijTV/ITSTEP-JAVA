package com.google.accounting.service;

import com.google.accounting.entity.Employee;
import com.google.accounting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service // спеціалізація анотації @Component – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional // - анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAll();
    }

    @Override
    @Transactional // - анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.saveOrUpdate(employee);
    }

    @Override
    @Transactional // - анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional // - анотація для підключення біна HibernateTransactionManager (описаний у applicationContext.xml) що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional - для роботи даної анотації обов'язковою є наявність конфігураційного рядка (<tx:annotation-driven transaction-manager="transactionManager"/>) у файлі applicationContext.xml
    public Employee getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }
}
