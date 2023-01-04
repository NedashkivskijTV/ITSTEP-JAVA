package com.google.accounting.repository;

import com.google.accounting.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAll();

    void saveOrUpdate(Employee employee);

    void deleteById(int id);

    Employee getById(int id);
}
