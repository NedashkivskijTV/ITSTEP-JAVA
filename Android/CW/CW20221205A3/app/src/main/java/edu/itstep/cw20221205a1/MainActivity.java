package edu.itstep.cw20221205a1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // змінні екземпляра класу, що відповідають активним елементам Актівіті
    // елемент для відображення списку
    private RecyclerView rvNumbers;

    private List<String> data;
    private NumberAdapter numberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ініціалізація змінних класу, що відповідають активним елементам Актівіті
        rvNumbers = findViewById(R.id.rvNumbers);

        // Ініціалізація колекції
        data = new ArrayList<>();

        // Імітація отримання колекції із значною кількістю даних
        for (int i = 1; i <= 300; i++) {
            data.add("data " + i);
        }

        // Ініціалізація Адаптера
        // приймає у параметри
        // - контекст
        // - файл-шаблон - де описано як відображатиметься кожен елемент колекції
        // - колекція даних
        //numberAdapter = new NumberAdapter(this, R.layout.list_item, data);
        //
        numberAdapter = new NumberAdapter(this, R.layout.list_item, data);

        // Встановлення ЛейаутМенеджера на елемент RecyclerView (rvNumbers), який відсутній за замовчуванням
        // приймає у параметри
        // - контекст,
        // - орієнтацію - одна з двох констант, що лежать у класі RecyclerView (VERTICAL, HORIZONTAL)
        // - напрямок відображення/скролінгу - false-стандартне відображення, true-відображення знизу вверх
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
                );

        // Встановлення LayoutManager на RecyclerView (rvNumbers)
        rvNumbers.setLayoutManager(layoutManager);

        // Приєднання Адаптера до елементу, що відорбражатиме дані
        rvNumbers.setAdapter(numberAdapter);

    }
}
