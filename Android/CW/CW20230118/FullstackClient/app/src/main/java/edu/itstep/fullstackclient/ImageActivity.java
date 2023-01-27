package edu.itstep.fullstackclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageActivity extends AppCompatActivity {

    // Оголошення змінних класу, що відповідатимуть за наявні у Актівіті об'єкти
    private ImageView ivFileContent;
    private TextView textView;
    private Button btnSelect;
    private Button btnSend;

    //Змінні для роботи з файлами
    public static final int REQUEST_CODE_GALLERY = 1;
    String filePath = ""; // змінна для збереження шляху до обраної картинки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // Ініціалізація View-об'єктів
        ivFileContent = findViewById(R.id.ivFileContent);
        textView = findViewById(R.id.textView);
        btnSelect = findViewById(R.id.btnSelect);
        btnSend = findViewById(R.id.btnSend);

        // Підключення подій
        ivFileContent.setOnClickListener(v -> { // демонстрація події по кліку на картинці
            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
        });

        // Алгоритм вибору файлу/зображення з галереї пристрою
        btnSelect.setOnClickListener(v -> {

            // Запит на наявність дозволу на доступ додатка до галереї
            int accessStorage = ContextCompat.checkSelfPermission(
                    getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

            // Перевірка наявності дозволу - якщо дозвіл є, тоді картинка витягується, якщо ні відбувається запит до користувача про надання відповідного дозволу
            // Застосовується застарілий метод - startActivityForResult, по якому відбувається очікування на результат у методі onActivityResult()
            if (accessStorage == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent();
                intent.setType("image/*"); // вказується що саме відкривати - галерея з усіма фото
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE_GALLERY); // запуск послідовності дій, щоб отримати результат - потім очікування коли в Актівіті повернеться фото, після чого спрацює метод onActivityResult()
            } else {

                // Запит до користувача на надання дозволу на доступ додатка до галереї
                //ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }

        });

        // Алгоритм відправки файлу на сервер
        btnSend.setOnClickListener(v -> {
            File file = new File(filePath); // створення об'єкта File за шляхом обраного фойла
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file); // формування тіла запиту (у ньому знаходитимуться дані про картинку) - зчитування інф з файлу
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestBody); // створення об'єкта передача body, який бере участь у самому запиті - у параметри передається назва об'єкта - "fie" (очікується на боці сервера)
            NetworkService.getInstance()
                    .getEmployeeApi()
                    .uploadImage(body)
                    .enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Toast.makeText(ImageActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(ImageActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });

    }

    // Метод спрацьовує після отримання даним Актівіті фотографії в результаті відпрацювання події по кліку на кнопку btnSelect
    // Отримання графічного файла
    // Результат отримується в об'єкті data, звідки витягуються дані у вигляді об'єкта Uri, а потім, за допомогою Uri отримуються дані про те, де знаходиться обрана картинка
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            filePath = RealPathUtil.getRealPath(this, uri); // Зберігає шлях до фото, обраного користувачем
            //Bitmap bitmap = BitmapFactory.decodeFile(filePath);
            //.imageView.setImageBitmap(bitmap);
            //binding.imageView.setImageURI(uri);
            ivFileContent.setImageURI(uri); // Відображення фото у відповідному елементі

        }
    }
}