package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
