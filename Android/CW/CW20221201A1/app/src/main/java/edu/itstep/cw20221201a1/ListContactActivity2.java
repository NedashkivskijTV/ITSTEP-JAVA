package edu.itstep.cw20221201a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListContactActivity2 extends AppCompatActivity {

    // змінні екземпляра класу, що відповідають активним елементам Актівіті
    // елемент для відображення списку
    private ListView lvContact;

    // Адаптер для роботи з ListView, що відображатиме колекцію ОБ'ЄКТІВ
    // SimpleAdapter - конфігурується, можна вказати звідки дані брати та куди відображати
    private SimpleAdapter adapter;

    // колекція ОБ'ЄКТІВ, що відображатимуться в елементі ListView
    private List<Map<String, String>> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact2);

        // Імітація запиту до БД на отримання потрібної колекції
        // Наповненням колекції ОБ'ЄКТІВ
        contacts = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("firstName", "Ivan");
        map.put("lastName", "Ivanenko");
        contacts.add(map);

        map = new HashMap<>();
        map.put("firstName", "Petro");
        map.put("lastName", "Petrenko");
        contacts.add(map);

        map = new HashMap<>();
        map.put("firstName", "Stepan");
        map.put("lastName", "Stepanenko");
        contacts.add(map);

        // ініціалізація змінних класу
        lvContact = findViewById(R.id.lvContact);

        // Створення Адаптера для роботи елемента ListView, що відображатиме колекцію ОБ'ЄКТІВ
        //
        // В параметри приймає
        // - Контекст,
        //
        // - колекція, в якій лежить будь-що, що є нащадком Map (HashMap, TreeMap, LinkedHashMap),
        // де ключі обов'язково типу String
        //
        // - шаблон відображення даних - посилання на стандартний (вбудований) шаблон
        // знаходиться за адресою android.R.layout.simple_list_item_2 (відображає 2 елемента TextView - вигляд див нижче),
        //
        // - інструкція для адаптера, щодо розташування конкретних елементів колекції у конкретних полях
        // (звідки взяти та куди покласти), а саме два масиви
        // 1 - типу String[] - масив ключів у потрібній послідовності
        // 2 - типу int[] - масив id куди потрібно покласти відповідно елементи попереднього масиву
        //
        // (оскільки шаблон вбудований - id знаходяться у об'єкті android.R.id.)
        // (коли адаптер візьме перший об'єкт колекції, він з неї витягне ім'я по ключу firstName та покладе у TextView з id text2,
        // а lastName - у  TextView з id text1)
        //
        // УВАГА - замість шаблона simple_list_item_2 можна використати власний xml файл та
        // встановити власні id
        adapter = new SimpleAdapter(
                this,
                contacts,
                android.R.layout.simple_list_item_2,
                new String[]{"firstName", "lastName"},
                new int[]{android.R.id.text2, android.R.id.text1}
        );

        // Встановити Адаптер у об’єкт ListView - метод setAdapter()
        lvContact.setAdapter(adapter);
    }
}