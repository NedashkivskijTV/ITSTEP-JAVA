package edu.itstep.fullstackserver.dao;

import edu.itstep.fullstackserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    // Створення запитів з використанням здравої логіки
    List<Employee>findAllByLastName(String lastName);

    List<Employee>findAllBySalaryBetween(int a, int b); // пошук по зарплаті між двома значеннями


    // Створення запиту з використанням SQL - діалекту
    @Query(value = "select * from employees", nativeQuery = true)
    List<Employee>getSome();

}

/*
    // Опис методів, що використовувались при стандартному підході до конфігурування застосунку (через Hibernate)

    List<Employee> getAllEmployee();

    //void saveOrUpdateEmployee(Employee employee); // дана реалізація не дає змогу повернути щойнододаний об'єкт з присвоєним id
    int saveOrUpdateEmployee(Employee employee);

    Employee getEmployeeById(int id);

    //String deleteEmployeeById(int id);
    void deleteEmployeeById(int id);
*/
