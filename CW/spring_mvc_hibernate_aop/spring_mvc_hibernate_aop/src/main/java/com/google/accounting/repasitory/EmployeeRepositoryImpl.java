package com.google.accounting.repasitory;

import com.google.accounting.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from com.google.accounting.entity.Employee", Employee.class)
                .getResultList();
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        System.out.println(employee);
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from com.google.accounting.entity.Employee where id = " + id).executeUpdate();
    }

    @Override
    public Employee getById(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }
}
