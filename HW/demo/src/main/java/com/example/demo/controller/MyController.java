package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        //Employee employee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return "employee with id = " + id + " was deleted";
    }

}
