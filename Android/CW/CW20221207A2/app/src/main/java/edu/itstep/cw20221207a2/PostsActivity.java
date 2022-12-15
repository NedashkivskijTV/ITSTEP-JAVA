package edu.itstep.cw20221207a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    // змінні екземпляра класу, що відповідають використовуваним елементам Актівіті
    private ListView lvPosts;

    // Адаптер
    private ArrayAdapter<String> adapter;
    // дані - відображатимуться заголовки постів
    private List<String> titles = new ArrayList<>();
    // Список постів для відображення детальної інф (в іншому місці)
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        // Ініціалізація даних
        lvPosts = findViewById(R.id.lvPosts);

        // Створення Адаптер
        adapter = new ArrayAdapter<>(
                this, // контекст
                android.R.layout.simple_list_item_1, // лейаут стандартний вбудований в SDK
                titles // дані (поки відсутні)
        );

        // Підключення події по натисканню на елемент списка (можливо у вигляді лямбда-функції)
        lvPosts.setOnItemClickListener((adapterView, view, position, id) -> {
            long userId = posts.get(position).getUserId();

            // TODO

        });
    }
}
