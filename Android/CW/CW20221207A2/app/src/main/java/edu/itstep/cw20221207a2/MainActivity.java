package edu.itstep.cw20221207a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // змінні екземпляра класу, що відповідають використовуваним елементам Актівіті
    private TextView tvPost;
    private Button btnGet;
    private Button btnNext;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ініціалізація елементів
        tvPost = findViewById(R.id.tvPost);
        btnGet = findViewById(R.id.btnGet);
        btnNext = findViewById(R.id.btnNext);
        progressBar = findViewById(R.id.progressBar);

        // Підключення слухача на натиснення кнопки - Реалізація запиту на отримання 1 поста
        btnGet.setOnClickListener(this::getPost);

        // Перехід на наступне Актівіті - відображатиме список
        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, PostsActivity.class));
        });
    }

    // Реалізація запиту на отримання 1 поста
    private void getPost(View view) {
        // видимий прогресбар
        progressBar.setVisibility(View.VISIBLE);

        // Реалізація коду, щодо отримання інф про 1 пост після відпрацювання методу onCreate
        PlaceholderAPI placeholderAPI = NetworkService.getInstance().getApi(); // отримання placeholderAPI - реалізація інтерфейса PlaceholderAPI

        // Створення об'єкта Call за допомогою якого буде здійснено запит, створюється за допомогою методу getPostById
        int randomPostPosition = (int) (Math.random() * (101 - 1)) + 1; // генерування рандомної позиції поста (1-100)
        //Call<Post> call = placeholderAPI.getPostById(2); // виклик методу отримання поста за id, повертає Call - об'єкт, що дозволяє виконувати асінхронний код (реалізовано на багатопоточності)
        Call<Post> call = placeholderAPI.getPostById(randomPostPosition); // виклик методу отримання поста за id, повертає Call - об'єкт, що дозволяє виконувати асінхронний код (реалізовано на багатопоточності)

        // поставити запит в чергу (запитів може бути багато), в параметри приймається callBack - функція, яка буде викликана пізніше - це інтерфейс, що має два методи
        // методи виконуватимуться не в ГОЛОВНОМУ потоці, та не заважатимуть працювати з телефоном - графіка не зависне
        call.enqueue(new Callback<Post>() {
            // Метод виконається в момент отримання результату з сервера
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body(); // повертає результат запиту
                tvPost.setText(post.getTitle());

                // НЕвидимий прогресбар
                progressBar.setVisibility(View.INVISIBLE);
            }

            // Метод виконається при виникненні помилки
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // Виведення тексту помилки
                Toast.makeText(MainActivity.this, "ERROR: " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


}