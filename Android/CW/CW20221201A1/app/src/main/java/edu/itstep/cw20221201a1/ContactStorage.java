package edu.itstep.cw20221201a1;

import java.util.ArrayList;
import java.util.List;

public class ContactStorage {
    public static List<Contact> getAllContacts(){
        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact(R.drawable.avatar, "Ivan", "Ivanov", "077-111-22-33", "ivan@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Petro", "Petrenko", "077-221-21-21", "petr@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Stepan", "Stepanenko", "067-331-31-31", "stepanen@gmail.com"));

        contacts.add(new Contact(R.drawable.avatar, "Ivan", "Ivanov", "077-111-22-33", "ivan@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Petro", "Petrenko", "077-221-21-21", "petr@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Stepan", "Stepanenko", "067-331-31-31", "stepanen@gmail.com"));

        contacts.add(new Contact(R.drawable.avatar, "Ivan", "Ivanov", "077-111-22-33", "ivan@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Petro", "Petrenko", "077-221-21-21", "petr@gmail.com"));
        contacts.add(new Contact(R.drawable.avatar, "Stepan", "Stepanenko", "067-331-31-31", "stepanen@gmail.com"));



        return contacts;
    }
}
