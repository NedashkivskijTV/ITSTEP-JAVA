package com.google.accounting.service;

import com.google.accounting.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    Employee getEmployeeById(int id);
}
