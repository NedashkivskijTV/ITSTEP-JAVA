package edu.itstep.cw20221201a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CustomListContactActivity extends AppCompatActivity {

    // змінні екземпляра класу, що відповідають активним елементам Актівіті
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

        // Підключення слухача до елемента списка
        lvPhoneBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // Отримання елемента за позицією
                Contact contact = contacts.get(position);

                // Виведення потрібної інф
                Toast.makeText(CustomListContactActivity.this,
                        "" + contact.getLastName() + " - " + contact.getPhone(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
