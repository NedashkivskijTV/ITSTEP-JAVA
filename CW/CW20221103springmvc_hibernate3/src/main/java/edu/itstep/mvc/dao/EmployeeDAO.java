package edu.itstep.mvc.dao;

import edu.itstep.mvc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    void SaveOrUpdate(Employee employee);

    void deleteById(int id);

    Employee getById(int id);
}
