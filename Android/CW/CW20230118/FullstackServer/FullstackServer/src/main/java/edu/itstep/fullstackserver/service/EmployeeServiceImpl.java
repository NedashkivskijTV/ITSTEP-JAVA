package edu.itstep.fullstackserver.service;

import edu.itstep.fullstackserver.dao.EmployeeDAO;
import edu.itstep.fullstackserver.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // спеціалізація анотації @Component (простір імен import org.springframework.stereotype.Service) – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля.
    private EmployeeDAO employeeDAO; // Впроваджена залежність від суеності EmployeeDAO (також має назву Repository)


    @Override
    @Transactional // анотація для підключення біна що здійснюватиме відкриття та закриття сесії – може бути відсутній оскільки використовується при здійсненні декількох послідовних запитів
/*
    public List<Employee> getAllEmployee() { // реалізація методу при використанні стандартного підходу - через реалізацію репозиторія
        return employeeDAO.getAllEmployee();
    }
*/
    public List<Employee> getAllEmployee() { // реалізація методу при використанні інструментарія Spring Data JPA - без DAO
        return employeeDAO.findAll();
    }


    @Override
    @Transactional // анотація для підключення біна що здійснюватиме відкриття та закриття сесії – може бути відсутній оскільки використовується при здійсненні декількох послідовних запитів
//    public void saveOrUpdateEmployee(Employee employee) { // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
//        return employeeDAO.saveOrtUpdateEmployee(employee);
//     }
/*
    public int saveOrUpdateEmployee(Employee employee) { // реалізація методу при використанні стандартного підходу - через реалізацію репозиторія
        return employeeDAO.saveOrUpdateEmployee(employee); // повертається id
    }
*/
    public Employee saveOrUpdateEmployee(Employee employee) { // реалізація методу при використанні інструментарія Spring Data JPA - без DAO
        return employeeDAO.save(employee); // повертається доданий об'єкт (може потребувати внесеня змін у відповідний метод інтерфейсу EmployeeDAO та метод контроллера )
    }


    @Override
    @Transactional // анотація для підключення біна що здійснюватиме відкриття та закриття сесії – може бути відсутній оскільки використовується при здійсненні декількох послідовних запитів
/*
    public Employee getEmployeeById(int id) { // реалізація методу при використанні стандартного підходу - через реалізацію репозиторія
        return employeeDAO.getEmployeeById(id);
    }
*/
    public Employee getEmployeeById(int id) { // реалізація методу при використанні інструментарія Spring Data JPA - без DAO
        Optional<Employee> optional = employeeDAO.findById(id); // повертає об'єкт типу Optional - контейнер для відповіді - дає змогу розрізняти відповідь у разі отримання null (може бути, що об'єкт існує і містить null, або об'єкта не існує взагалі)

        // Алгоритм отримання даних з контейнера Optional
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }

        return employee;
    }


    @Override
    @Transactional // анотація для підключення біна що здійснюватиме відкриття та закриття сесії – може бути відсутній оскільки використовується при здійсненні декількох послідовних запитів
    //public String deleteEmployeeById(int id) {
/*
    public void deleteEmployeeById(int id) { // реалізація методу при використанні стандартного підходу - через реалізацію репозиторія
        employeeDAO.deleteEmployeeById(id);
        //return employeeDAO.deleteEmployeeById(id);
    }
*/
    public void deleteEmployeeById(int id) { // реалізація методу при використанні інструментарія Spring Data JPA - без DAO
        employeeDAO.deleteById(id);
    }
}
