package edu.itstep.phonebook.repository;

import edu.itstep.phonebook.entity.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Contact> getAllContacts_Repository() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Contact f", Contact.class)
                .getResultList();
    }

    @Override
    public void saveOrUpdateContact_Repository(Contact contact) {
        System.out.println(contact);
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(contact);
    }

    @Override
    public void deleteContactById_Repository(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Contact where id = " + id)
                .executeUpdate();
    }

    @Override
    public Contact getContactById_Repository(int id) {
        return sessionFactory.getCurrentSession().get(Contact.class, id);
    }
}
