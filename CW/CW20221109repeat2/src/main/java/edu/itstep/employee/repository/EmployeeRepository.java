package edu.itstep.employee.repository;

import edu.itstep.employee.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAll();

    void saveOrUpdate(Employee employee);

    void deleteById(int id);

    Employee getById(int id);
}
