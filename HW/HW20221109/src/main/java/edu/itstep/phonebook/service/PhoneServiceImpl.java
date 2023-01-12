package edu.itstep.phonebook.service;

import edu.itstep.phonebook.entity.Phone;
import edu.itstep.phonebook.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service // спеціалізація анотації @Component (простір імен import org.springframework.stereotype.Service) – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public class PhoneServiceImpl implements PhoneService{

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля.
    private PhoneRepository phoneRepository; // впровадження залежності PhoneRepository (створюється фреймворком – створено відповідний бін, але потрібно впровадити)

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public List<Phone> getAllPhones() {
        return phoneRepository.getAllPhones_Repository();
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public void saveOrUpdatePhone(Phone phone) {
        phoneRepository.saveOrUpdatePhone_Repository(phone);
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public void deletePhoneById(int id) {
        phoneRepository.deletePhoneById_Repository(id);
    }

    @Override
    @Transactional // анотація для підключення біна HibernateTransactionManager що здійснюватиме відкриття та закриття сесії - додається простір імен javax.transaction.Transactional
    public Phone getPhoneById(int id) {
        return phoneRepository.getPhoneById_Repository(id);
    }
}
