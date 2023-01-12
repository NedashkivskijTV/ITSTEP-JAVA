package edu.itstep.cw20221207a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        lvPosts.setAdapter(adapter);

        // Отримання даних з сервера
        NetworkService
                .getInstance()
                .getApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        posts = response.body();
                        for (Post post : posts) {
                            titles.add(post.getTitle());
                        }

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {

                    }
                });


        // Підключення події по натисканню на елемент списка (можливо у вигляді лямбда-функції)
        lvPosts.setOnItemClickListener((adapterView, view, position, id) -> {
            long userId = posts.get(position).getUserId();
            // отримали id користувача, який написав цей пост
            // TODO

            Toast.makeText(this, String.valueOf(userId), Toast.LENGTH_SHORT).show();

        });
    }
}
