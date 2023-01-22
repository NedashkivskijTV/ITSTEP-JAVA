package edu.itstep.fullstackserver.service;

import edu.itstep.fullstackserver.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    //void saveOrUpdateEmployee(Employee employee); // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
    //int saveOrUpdateEmployee(Employee employee); // при реалізації методу стандартним шляхом (з реалізацією DAO, через метод merge()) є змога повернути id щойнододаного елемента - getId()
    Employee saveOrUpdateEmployee(Employee employee); // при використанні підходу Spring Data JPA, метод save() повертає доданий об'єкт

    Employee getEmployeeById(int id);

    //String deleteEmployeeById(int id);
    void deleteEmployeeById(int id);
}
