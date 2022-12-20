package com.google.rest.controller;

import com.google.rest.entity.Employee;
import com.google.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping( "/employees")
    public List<Employee>getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
        return "was deleted";
    }
}
