package edu.itstep.cw20221201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListContactActivity extends AppCompatActivity {

//    private ListView lvContacts;
//    private String[] contacts;
//    private ArrayAdapter<String> adapter;

    private ListView lvContacts;
    private SimpleAdapter adapter;
    private List<Map<String, String>> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

//        lvContacts = findViewById(R.id.lvContacts);
//        contacts = new String[]{"Ivan Ivanov", "Petr Petrov", "Stepan Stepanov"};
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
//        lvContacts.setAdapter(adapter);


        contacts = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("firstName", "Ivan");
        map.put("lastName", "Ivanov");
        contacts.add(map);

        map = new HashMap<>();
        map.put("firstName", "Petr");
        map.put("lastName", "Petrov");
        contacts.add(map);

        map = new HashMap<>();
        map.put("firstName", "Stepan");
        map.put("lastName", "Stepanov");
        contacts.add(map);

        lvContacts = findViewById(R.id.lvContacts);
        adapter = new SimpleAdapter(
                this,
                contacts,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"firstName", "lastName"},
                new int[]{android.R.id.text2, android.R.id.text1}
                );

        lvContacts.setAdapter(adapter);
    }
}
