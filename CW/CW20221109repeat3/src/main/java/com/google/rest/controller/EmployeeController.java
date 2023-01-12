package com.google.rest.controller;

import com.google.rest.entity.Employee;
import com.google.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// спеціальний контроллер, використовуваний у веб-сервисах RESTFul, и еквівалентний @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    // на сетер/конструктор/поле, вказує на створення залежності (зависимости) за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    public EmployeeService employeeService;

    /**
     * Отримання усіх об'єктів з БД
     *
     * @return
     */
    //@RequestMapping(value = "/employees", method = RequestMethod.GET) // універсальна URL-адреса - даний метод буде спрацьовувати коли здійснюватиметься будь який HTTP-запит (POST, GET, PUT, UPDATE ...), у даної анотації є атрибут method(), що дозволяє визначити на який запит має спрацювати метод
    @GetMapping("/employees")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return employees;
    }

    /**
     * Отримання об'єкта за id
     *
     * @param id
     * @return
     * @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
     */
    @GetMapping("/employees/{id}")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public Employee getEmployeeById(@PathVariable int id) {
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    /**
     * Збереження екземпляра Employee
     *
     * @param employee
     * @return оскільки зберагіється екземпляр ссилочного типу даних та збереження відбуватиметься за посиланням,
     * Hibernate додасть за цим посиланням id - повернений об'єкт вже матиме id за яким він збережений до БД
     * @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
     */
    @PostMapping("/employees")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу POST
    public Employee addEmployee(@RequestBody Employee employee) {
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
        employeeService.saveOrUpdateEmployee(employee);
        return employee; // оскільки зберагіється екземпляр ссилочного типу даних та збереження відбуватиметься за посиланням, Hibernate додасть за цим посиланням id - повернений об'єкт вже матиме id за яким він збережений до БД
    }

    /**
     * Оновленння екземпляра (employee) у БД
     *
     * @param employee
     * @return
     * @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при PUT запиті)
     */
    @PutMapping("/employees")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу PUT
    public Employee updateEmployee(@RequestBody Employee employee) {
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при PUT запиті)
        employeeService.saveOrUpdateEmployee(employee); // метод saveOrUpdateEmployee працює відповідно  до наявності/відсутності параметра id - у разі наявності -оновлює дані, у разі відсутності - зберігає новий об'єкт
        return employee; // повертається об'єкт після внесення змін
    }

    /**
     * Видалення екземпляра (Employee) за id
     *
     * @param id
     */
    @DeleteMapping("/employees/{id}")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу DELETE
    public void deleteEmployeeById(@PathVariable int id) {
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах path у запиті
        employeeService.deleteEmployeeById(id);
    }

}
