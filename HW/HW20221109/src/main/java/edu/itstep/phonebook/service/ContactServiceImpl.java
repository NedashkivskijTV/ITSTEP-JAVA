package edu.itstep.phonebook.service;

import edu.itstep.phonebook.entity.Contact;
import edu.itstep.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts_Repository();
    }

    @Override
    @Transactional
    public void saveOrUpdateContact(Contact contact) {
        contactRepository.saveOrUpdateContact_Repository(contact);
    }

    @Override
    @Transactional
    public void deleteContactById(int id) {
        contactRepository.deleteContactById_Repository(id);
    }

    @Override
    @Transactional
    public Contact getContactById(int id) {
        return contactRepository.getContactById_Repository(id);
    }
}
