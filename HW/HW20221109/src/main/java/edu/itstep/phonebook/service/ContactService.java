package edu.itstep.phonebook.service;

import edu.itstep.phonebook.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

    List<Contact> getAllContacts();

    void saveOrUpdateContact(Contact contact);

    void deleteContactById(int id);

    Contact getContactById(int id);
}
