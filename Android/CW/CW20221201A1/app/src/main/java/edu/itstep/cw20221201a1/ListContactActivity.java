package edu.itstep.cw20221201a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListContactActivity extends AppCompatActivity {

    // змінні класу, що відповідають активним елементам Актівіті
    // елемент для відображення списку
    private ListView lvContact;

    // колекція елементів, що відображатимуться
    private String[] contacts;

    // Адаптер для роботи з ListView
    private ArrayAdapter<String> adapter;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        // ініціалізація змінних класу
        lvContact = findViewById(R.id.lvContact);

        // Наповненням колекції
        contacts = new String[] {"Ivan Ivanenko", "Petro Petrenko", "Stepan Stepanenko"};

        // Створення Адаптера для роботи елемента ListView
        // В параметри передати Контекст, посилання на стандартний (вбудований) шаблон
        // знаходиться за адресою android.R.layout.simple_list_item_1, та
        // колекція контактів - contacts
        // УВАГА - використання шаблона simple_list_item_1 дозволяє відображати списки з простим зовнішнім виглядом
        // для складних шаблонів потрібно використовувати інший адаптер
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);

        // Встановити Адаптер у об’єкт ListView - метод setAdapter()
        lvContact.setAdapter(adapter);
    }
}