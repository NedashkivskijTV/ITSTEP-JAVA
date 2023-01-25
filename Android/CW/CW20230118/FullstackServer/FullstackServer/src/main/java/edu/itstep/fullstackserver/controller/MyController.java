package edu.itstep.fullstackserver.controller;

import edu.itstep.fullstackserver.entity.Employee;
import edu.itstep.fullstackserver.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RestController – спеціальний контроллер, використовуваний у веб-сервисах RESTFul, и еквівалентний @Controller + @ResponseBody – (простір імен import org.springframework.web.bind.annotation.RestController;) – замість використосуваної раніше анотації @Controller
public class MyController {

    @Autowired
    // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля.
    private EmployeeService employeeService;

    @GetMapping("/employees")
    // // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public List<Employee> getAllEmployee() {
//        List<Employee> employees = employeeService.getAllEmployee();
//        return employees;
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public Employee getEmployeeById(@PathVariable int id) {
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу POST
//    public Employee addEmployee(@RequestBody Employee employee){ // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
//        employeeService.saveOrUpdateEmployee(employee); // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
//        return employee; // повертає об'єкт, що додавався, але id = 0
//     }
//    public int addEmployee(@RequestBody Employee employee){
//        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
//        int newId = employeeService.saveOrUpdateEmployee(employee);
//        return newId; // як варіант, можна повертати об'єкт Employee, але передбачивши у моделі сеттер для id, додати присвоений id до поверненого об'єкта
//    }
    public Employee addEmployee(@RequestBody Employee employee) { // Внесення змін у метод після застосування інструментарія Spring Data JPA - без реалізації DAO
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
        return employeeService.saveOrUpdateEmployee(employee); // повернення щойнододаного об'єкта після додавання до БД та присвоєння id
    }

    @PutMapping("/employees")
    // // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу PUT
    public Employee updateEmployee(@RequestBody Employee employee) {
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{id}")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу DELETE
    public Employee deleteEmployeeById(@PathVariable int id) {
        Employee employee = getEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return employee;
    }

    /*
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id){
    //public void deleteEmployeeById(@PathVariable int id){
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
        //employeeService.deleteEmployeeById(id);
        //return "employee with id = " + id + " was deleted";

        // Алгоритм видалення з попередньою перевіркою наявності даних та перевіркою результатів видалення
        Employee employee = getEmployeeById(id);
        String message;
        if(employee != null){
            employeeService.deleteEmployeeById(id);
            if(getEmployeeById(id) == null){
                message = "Element with id = " + id + " was deleted";
            } else {
                message = "The element with id = " + id + " was not deleted. Try again later";
            }
        } else {
            message = "The element with the specified id = " + id + " is absent in the database";
        }
            return message;
    }
*/

}
