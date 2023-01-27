package com.example.fullstackserver.controller;

import com.example.fullstackserver.entity.Employee;
import com.example.fullstackserver.service.EmployeeService;
import com.example.fullstackserver.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    ImageStorageService imageStorageService;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getAllEmployees(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdateEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/upload-image")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
        System.out.println("Картинка прилетела");
        imageStorageService.uploadImage(file);
        return "OK!";
    }

}
