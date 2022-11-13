package com.google.rest.service;

import com.google.rest.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    Employee getEmployeeById(int id);
}
