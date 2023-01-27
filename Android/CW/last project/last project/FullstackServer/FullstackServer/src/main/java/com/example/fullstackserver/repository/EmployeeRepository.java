package com.example.fullstackserver.repository;

import com.example.fullstackserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByLastName(String lastName);
    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getSome();
}
