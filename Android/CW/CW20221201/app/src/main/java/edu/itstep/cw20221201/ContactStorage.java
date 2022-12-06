package edu.itstep.cw20221201;

import java.util.ArrayList;
import java.util.List;

public class ContactStorage {
    public static List<Contact> getAllContacts(){
        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact(R.drawable.avatar, "Ivan", "Ivanenko", "0671112233", "ivan@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Petro", "Petrenko", "0672223344", "petro@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Stepan", "Stepanenko", "0774445566", "stepannn@gmail.com"));

        return contacts;
    }
}
