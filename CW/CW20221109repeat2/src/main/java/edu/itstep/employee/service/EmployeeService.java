package edu.itstep.employee.service;

import edu.itstep.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // спеціалізація анотації @Component – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public interface EmployeeService {

    List<Employee> getAllEmployee();

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    Employee getEmployeeById(int id);

}
