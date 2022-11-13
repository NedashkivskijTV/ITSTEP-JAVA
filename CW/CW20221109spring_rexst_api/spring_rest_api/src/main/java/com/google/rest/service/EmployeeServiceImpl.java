package com.google.rest.service;

import com.google.rest.entity.Employee;
import com.google.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAll();
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }
}
