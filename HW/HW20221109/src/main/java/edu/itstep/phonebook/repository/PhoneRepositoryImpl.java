package edu.itstep.phonebook.repository;

import edu.itstep.phonebook.entity.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // – вказує на конкретний клас, який взаємодіятиме з БД
public class PhoneRepositoryImpl implements PhoneRepository{

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності за допомогою даного сетера/конструктора/поля
    private SessionFactory sessionFactory; // впровадження залежність SessionFactory - За допомогою DI & IoC (створюється фреймворком – створено відповідний бін, але потрібно впровадити)

    @Override
    public List<Phone> getAllPhones_Repository() {
        return sessionFactory
                .getCurrentSession() // отримання сесії (відкриття та закриття сесії здійснюватиме бін HibernateTransactionManager (описаний у applicationContext.xml, якщо кеонфігураційний файл налаштовується за допомогою xml) для підключення якого потрібно у класі-шмплементації сервісу додати до відповідного методу аномацію @Transactional)
                .createQuery("from Phone", Phone.class) // запит на отримання усіх даних з таблиці - стврюється об'єкт Query<Phone> = createQuery("from Phone", Phone.class) -спеціальний об'єкт для створення запиту
                .getResultList(); // директива на отримання результатів запиту у вигляді списку
    }

    @Override
    public void saveOrUpdatePhone_Repository(Phone phone) {
        System.out.println(phone);
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(phone); // метод, що забезпечує збереження або оновлення даних у БД в залежності від наявності у об'єкта поля id - якщо ідентифікатор присутній, значить об'єкт вже існує у БД та потрібно його оновити
    }

    @Override
    public void deletePhoneById_Repository(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Phone where id = " + id)
                .executeUpdate();
    }

    @Override
    public Phone getPhoneById_Repository(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Phone.class, id);
    }
}
