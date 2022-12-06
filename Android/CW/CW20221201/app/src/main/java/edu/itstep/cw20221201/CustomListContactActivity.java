package edu.itstep.cw20221201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class CustomListContactActivity extends AppCompatActivity {

    private ListView lvPhoneBook;
    private List<Contact> contacts;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_contact);

        lvPhoneBook = findViewById(R.id.lvPhoneBook);
        contacts = ContactStorage.getAllContacts();


    }
}