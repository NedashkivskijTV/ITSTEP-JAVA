package edu.mywork.fullstackserver.controller;

import edu.mywork.fullstackserver.entity.Employee;
import edu.mywork.fullstackserver.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @RequestMapping("/login")
//    public String goLoginPage(){
//        return "login.html";
//    }

    @GetMapping("/employees") // // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public List<Employee> getAllEmployee(){
//        List<Employee> employees = employeeService.getAllEmployee();
//        return employees;
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public Employee getEmployeeById(@PathVariable int id){
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу POST
//    public Employee addEmployee(@RequestBody Employee employee){ // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
//        employeeService.saveOrUpdateEmployee(employee); // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
//        return employee; // повертає об'єкт, що додавався, але id = 0
//     }
    public Employee addEmployee(@RequestBody Employee employee){
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
        //int newId = employeeService.saveOrUpdateEmployee(employee);
        return employeeService.saveOrUpdateEmployee(employee); // як варіант, можна повертати об'єкт Employee, але передбачивши у моделі сеттер для id, додати присвоений id до поверненого об'єкта
    }

    @PutMapping("/employees") // // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу PUT
    public Employee updateEmployee(@RequestBody Employee employee){
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу DELETE
    public String deleteEmployeeById(@PathVariable int id){
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
        employeeService.deleteEmployeeById(id);
        return "employee with id = " + id + " was deleted";
    }

}
