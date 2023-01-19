package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeDao.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeDao.deleteEmployeeById(id);
    }
}
