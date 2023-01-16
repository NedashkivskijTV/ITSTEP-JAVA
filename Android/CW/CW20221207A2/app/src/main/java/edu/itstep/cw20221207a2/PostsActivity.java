package edu.itstep.cw20221207a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    // Адаптер - для відображення даних у лейауті simple_list_item_1
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

        // Створення Адаптера - використовується для відображення колекції
        adapter = new ArrayAdapter<>(
                this, // контекст
                android.R.layout.simple_list_item_1, // лейаут стандартний вбудований в Android SDK
                titles // дані (поки відсутні) -????????????????????????????
        );
        lvPosts.setAdapter(adapter); // Встановлення адаптера на поле ListView


        // Алгоритм отримання інф (про усі пости) з сервера - забезпечує Адаптер даними
        // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        // Отримання даних з сервера - варіант ланцюжкової (цепочкою) реалізації
        NetworkService
                .getInstance() // повертає екземпляр класу NetworkService
                .getApi() // повертає реалізацію інтерфейса PlaceholderAPI
                .getAllPosts() // повертає спеціальний об'єкт Call
                .enqueue(new Callback<List<Post>>() { // enqueue - постановка запиту (об'єкт Call) в чергу на виконання - в параметри приймає Callback - функцію, яка буде викликана пізніше - це інтерфейс, що має два методи onResponse() та onFailure та виконуватимуться поза основним потоком

                    // Виконується після отримання відповіді
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        posts = response.body(); // отримання списку з тіла відповіді

                        // Формування колекції заголовків (елементів title) з колекції постів
                        // Реалізація може бути довільна (доприкладу через stream api)
                        for (Post post : posts) {
                            titles.add(post.getTitle()); // додавання елемента (заголовка) до колекції
                        }

                        // Сповіщення адаптера про оновлення даних
                        adapter.notifyDataSetChanged();
                    }

                    // Виконується при виникненні помилки
                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {

                        // Повідомлення про помилку, що виведеться при її виникненні
                        Toast.makeText(PostsActivity.this, "ERROR: " + t, Toast.LENGTH_SHORT).show();
                    }
                });
        // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


        // Підключення події по натисканню на елемент списка (можливо у вигляді лямбда-функції)
        lvPosts.setOnItemClickListener((adapterView, view, position, id) -> {

            // отримання id користувача, який написав обраний пост
            long userId = posts.get(position).getUserId();

            // Отримавши id користувача можна отримати будь яку інф про нього,
            // для цього потрібно створити відповідний запит (аналогічний getPostById() для об'єкта User),
            // підготувати модель (клас User),
            // підготувати запитдо БД

            // Виведення id користувача, який написав пост (по кліку на пост)
            Toast.makeText(this, "User id - " + String.valueOf(userId), Toast.LENGTH_SHORT).show();
        });
    }
}
