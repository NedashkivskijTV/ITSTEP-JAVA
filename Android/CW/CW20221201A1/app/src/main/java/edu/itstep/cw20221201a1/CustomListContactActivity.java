package edu.itstep.cw20221201a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class CustomListContactActivity extends AppCompatActivity {

    // змінні класу, що відповідають активним елементам Актівіті
    // елемент для відображення списку
    private ListView lvPhoneBook;

    // колекція ОБ'ЄКТІВ, що відображатимуться в елементі ListView
    private List<Contact> contacts;

    // Створення змінної-адаптера (створений у окремому класі)
    private ContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_contact);

        // ініціалізація змінних класу
        lvPhoneBook = findViewById(R.id.lvPhoneBook);

        // Імітація запиту до БД на отримання потрібної колекції
        contacts = ContactStorage.getAllContacts();

        // ініціалізація адаптера
        adapter = new ContactAdapter(
                this,
                R.layout.item_list,
                contacts
        );

        // Встановлення адаптера у список
        lvPhoneBook.setAdapter(adapter);
    }
}
