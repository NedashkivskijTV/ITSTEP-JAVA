package edu.mywork.fullstackserver.repository;

import edu.mywork.fullstackserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    List<Employee> getAllEmployee();
//
//    //void saveOrUpdateEmployee(Employee employee); // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
//    int saveOrUpdateEmployee(Employee employee);
//
//    Employee getEmployeeById(int id);
//
//    //String deleteEmployeeById(int id);
//    void deleteEmployeeById(int id);

}
