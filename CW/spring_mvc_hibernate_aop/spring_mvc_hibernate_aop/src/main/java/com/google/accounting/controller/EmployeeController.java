package com.google.accounting.controller;

import com.google.accounting.entity.Employee;
import com.google.accounting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAll(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";
    }

    @RequestMapping("/createEmployee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        Employee employee =  employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }
}
