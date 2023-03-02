package edu.mywork.fullstackserver.service;

import edu.mywork.fullstackserver.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    //void saveOrUpdateEmployee(Employee employee); // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
    Employee saveOrUpdateEmployee(Employee employee);

    Employee getEmployeeById(int id);

    //String deleteEmployeeById(int id);
    void deleteEmployeeById(int id);

}
