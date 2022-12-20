package com.google.rest.repository;


import com.google.rest.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee>getAll();

    void saveOrUpdate(Employee employee);

    void deleteById(int id);

    Employee getById(int id);
}
