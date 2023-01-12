package edu.itstep.phonebook.service;

import edu.itstep.phonebook.entity.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // спеціалізація анотації @Component – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public interface PhoneService {

    List<Phone> getAllPhones();

    void saveOrUpdatePhone(Phone phone);

    void deletePhoneById(int id);

    Phone getPhoneById(int id);

/*
    List<Employee> getAllEmployee();

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    Employee getEmployeeById(int id);
*/

}
