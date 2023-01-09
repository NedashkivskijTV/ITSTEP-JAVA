package edu.itstep.employee.service;

import edu.itstep.employee.entity.Employee;
import edu.itstep.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service // спеціалізація анотації @Component (простір імен import org.springframework.stereotype.Service) – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    private EmployeeRepository employeeRepository; // впровадження залежності EmployeeRepository (створюється фреймворком – створено відповідний бін, але потрібно впровадити) – потрібно додати відповідне поле класу до якого додати анотацію @Autowired

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAll();
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.saveOrUpdate(employee);
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public Employee getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }
}
