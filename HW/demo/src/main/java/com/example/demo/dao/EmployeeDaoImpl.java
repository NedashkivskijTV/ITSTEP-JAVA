package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee() {
        //entityManager.unwrap()
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        entityManager.createQuery("delete from Employee where id = " + id).executeUpdate();
    }
}
