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
public class MyController {

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля
    private EmployeeService employeeService;

//    @RequestMapping("/")
//    public String showFirstView() {
//        return "first-view";
//    }

    /**
     * отримання даних з БД
     * оскільки контролер може виконувати різні ф-ції, для їх реалізації використовують СЕРВІСИ
     * для доступу до БД використовується змінна класу - сервіс employeeService
     * @param model
     * @return
     */
    @RequestMapping("/") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати (/ - кореневий) – при заході на кореневий URL буде запущено метод  showAll, у return вказується назва представлення, яке відображатиметься при переході користувача за адресою / (вказана у анотації)
    public String showAll(Model model){ // в параметрах вказано модель для передачі даних між контроллером та представленням
        List<Employee> employees = employeeService.getAllEmployees(); // отримання колекції з БД
        model.addAttribute("employees", employees); // передача даних до моделі для їх отримання у представленні
        return "all-employees";
    }

    /**
     * створення елемента типу Employee - по натисненню на відповідну кнопку перенаправляє
     * на сторінку створення об'єкта (на форму)
     * @param model
     * @return
     */
    @RequestMapping("/createEmployee") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати – у return вказується назва представлення, яке відображатиметься при переході користувача за адресою / (вказана у анотації)
    public String createEmployee(Model model){ // в параметрах вказано модель для передачі даних між контроллером та представленням
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    /**
     * збереження об'єкта Employee до БД
     * @param employee
     * @return
     */
    @RequestMapping("/saveEmployee") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати – у return вказується назва представлення, яке відображатиметься при переході користувача за адресою / (вказана у анотації)
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // @ModelAttribute("employee") - анотація, що дозволяє отримати за КЛЮЧЕМ (вказаний у параметрах анотації)
        // з моделі дані, отримані у параметрах методу
        employeeService.saveOrUpdateEmployee(employee);
        return "redirect:/";
    }

    /**
     * знищення об'єкта Employee за id
     * @param id
     * @return
     */
    @RequestMapping("/deleteEmployee") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати – у return вказується назва представлення, яке відображатиметься при переході користувача за адресою / (вказана у анотації)
    public String deleteEmployee(@RequestParam("employeeId") int id){
        // @RequestParam("employeeId") - для отримання потрібних даних у параметрах методу вказується змінна відповідного типу,
        // а до змінної анотація @RequestParam у параметрах якої вказується рядок, значення якого відповідає відповідному параметру,
        // у даному разі це атрибут, що зберігає id конкретного елемента таблиці, яка міститься у представленні що відображає список елементів Employee (/)
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    /**
     * оновлення об'єкта Employee за id
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/updateEmployee") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати – у return вказується назва представлення, яке відображатиметься при переході користувача за адресою / (вказана у анотації)
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){ // в параметрах вказано модель для передачі даних між контроллером та представленням
        // @RequestParam("employeeId") - для отримання потрібних даних у параметрах методу вказується змінна відповідного типу,
        // а до змінної анотація @RequestParam у параметрах якої вказується рядок, значення якого відповідає відповідному параметру,
        // у даному разі це атрибут, що зберігає id конкретного елемента таблиці, яка міститься у представленні що відображає список елементів Employee (/)
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

}
