package edu.mywork.fullstackserver.service;

import edu.mywork.fullstackserver.entity.Employee;
import edu.mywork.fullstackserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);

        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }

        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}