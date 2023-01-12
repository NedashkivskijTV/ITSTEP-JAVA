package edu.itstep.phonebook.repository;

import edu.itstep.phonebook.entity.Phone;

import java.util.List;

public interface PhoneRepository {

    List<Phone> getAllPhones_Repository();

    void saveOrUpdatePhone_Repository(Phone phone);

    void deletePhoneById_Repository(int id);

    Phone getPhoneById_Repository(int id);

/*
    List<Employee> getAll();

    void saveOrUpdate(Employee employee);

    void deleteById(int id);

    Employee getById(int id);
*/

}
