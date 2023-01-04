package edu.itstep.mvc.controller;

import edu.itstep.mvc.dao.EmployeeDAO;
import edu.itstep.mvc.dao.EmployeeDAOImpl;
import edu.itstep.mvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

//    @RequestMapping("/")
//    public String showFirstView(){
//        return "first-view";
//    }

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля. Якщо для конструктора не вказано @Autowired SpringContainer спробує самостійно
    private EmployeeDAO employeeDAO; // впровадження залежності - для надання контроллеру доступу до EmployeeDAO - у змінній лежатиме посилання да екземпляр класу EmployeeDAOImpl

    /**
     * отримання даних з БД про усіх співробітників
     * оскільки контролер може виконувати різні ф-ції, для їх реалізації використовують СЕРВІСИ
     * для доступу до БД використовується сервіс (employeeDAO)
     */
    @RequestMapping("/") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати (/ - кореневий) – при заході на кореневий URL буде запущено метод  showAllEmployee, у return вказується назва представлення, яке відображатиметься при переході користувача за адресою / (вказана у анотації)
    public String showAllEmployee(Model model){ // в параметрах вказано модель для передачі даних між контроллером та представленням

        List<Employee> employees = employeeDAO.getAll(); // отримання колекції з БД
        model.addAttribute("allEmployees", employees); // передача даних до моделі для їх отримання у представленні

        return "employees-view"; // назва представлення довільна
    }

    /**
     * створення обє'кта Employee - по натисненню на відповідну кнопку перенаправляє на сторінку створення об'єкта (на форму), звідти на
     * @param model
     * @return
     */
    @RequestMapping("/createEmployee") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати даному конкретному методу – при заході на кореневий URL /createEmployee буде запущено метод  createEmployee (назва може відрізнятись від адреси), у return вказується назва представлення, яке відображатиметься в результаті відпрацювання методу
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    /**
     * збереження об'єкта Employee у БД
     * @param employee
     * @return
     */
    @RequestMapping("/saveEmployee") // зв’язує URL-адресу з методом контроллера  – вказує на який URL потрібно буде реагувати даному конкретному методу – при заході на кореневий URL /saveEmployee буде запущено метод  saveEmployee (назва може відрізнятись від адреси), у return вказується назва представлення, яке відображатиметься в результаті відпрацювання методу
    // @ModelAttribute("employee") - анотація, що дозволяє отримати за КЛЮЧЕМ (вказаний у параметрах анотації) з моделі дані, отримані у параметрах методу
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeDAO.SaveOrUpdate(employee);
        return "redirect:/";
    }

    /**
     * Видалення об'єкта Employee за id
     * @param id
     * @return
     */
    @RequestMapping("/deleteEmployee")
    // @RequestParam("employeeId") - для отримання потрібних даних у параметрах методу вказується змінна відповідного типу,
    // а до змінної анотація @RequestParam у параметрах якої вказується рядок, значення якого відповідає відповідному параметру,
    // у даному разі це атрибут, що зберігає id конкретного елемента таблиці, яка міститься у представленні що відображає список елементів Employee (/)
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeDAO.deleteById(id);
        return "redirect:/";
    }

    /**
     * Оновлення об'єкта Employee за id
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/updateEmployee")
    // @RequestParam("employeeId") - для отримання потрібних даних у параметрах методу вказується змінна відповідного типу,
    // а до змінної анотація @RequestParam у параметрах якої вказується рядок, значення якого відповідає відповідному параметру,
    // у даному разі це атрибут, що зберігає id конкретного елемента таблиці, яка міститься у представленні що відображає список елементів Employee (/)
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeDAO.getById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

}
