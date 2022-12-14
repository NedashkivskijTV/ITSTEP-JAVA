package edu.itstep.cw20221205a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    //Створення інтерфейсу для прихначення події по натисканню на елемент відображеної колекції
    interface OnNumberClickListener{
        void onNumberClick(int position);
    }

    // Змінні екземпляра класу - відповідають параметрам, що отримує конструктор
    private Context context;
    private int resource;
    private List<String> data;

    int count = 1; // змінна для контроля кількості створених контейнерів NumberViewHolder

    // Забезпечення роботи слухача по натисненню на елемент ----------------------------------------
    private View.OnClickListener onItemClickListener;

    // конструктор класу
    //public NumberAdapter(Context context, int resource, List<String> data) {
    public NumberAdapter(Context context, int resource, List<String> data) {
        // Ініціалізація змінних класу
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    // Забезпечення роботи слухача по натисненню на елемент ----------------------------------------
    public void setOnItemClickListener(View.OnClickListener listener){
        onItemClickListener = listener;
    }

    // Метод відповідає за створення контейнерів для відображення даних
    // відпрацьовує обмежену кількість раз
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Створення елемента - наповнювача та його ініціалізація
        LayoutInflater inflater = LayoutInflater.from(context);

        // Наповнення контейнера даними - приймає у параметри файл-шаблон, створений для забезпесення відображення 1 елемента
        // parent та false - лишаються без змін (прикріпляти окремо до батьківського контейнера не потрібно - відпрацює автоматично)
        View item = inflater.inflate(R.layout.list_item, parent, false);

        //Створити об'єкт, що повертатиметься (об'єкт внутрішнього класу)
        // в параметри передати щойно створений об'єкт item - об'єкт на основі xml файла-шаблона
        NumberViewHolder numberViewHolder = new NumberViewHolder(item);

        // Виведення у текстове поле tvSecond інформації про номер створеного контейнера NumberViewHolder
        numberViewHolder.tvSecond.setText("holder#" + count++);

        // повернення створеного NumberViewHolder
        return numberViewHolder;
    }

    // метод спрацює стільки разів, скільки потрібно буде відображати даних
    // від час скролингу відпрацьовуватиме кожен раз поновій
    // отримує у параметри контейнер (внутрішній клас), створений для відображення елементів - даних елементів обмежена кількість
    // та position - позиція даних з колекції, які потрібно відобразити - даний елемент відповідає кількості елементів у колекції, що відображається
    // position використовується для отримання даних з колекції
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        String value = data.get(position); // отримання даних з колекції за позицією

        // розміщення отриманих даних у елементах об'єкта NumberViewHolder
        holder.tvFirst.setText(value);
    }

    @Override
    public int getItemCount() { // повертає кількість даних, що ми збираємось відображати
        return data.size(); // розмір колекції
    }

    // Внутрішній клас - для створення обмеженої кількості елементів,
    // що будуть задіяні при відображенні елементів колекції (будуть перевикористовуватись)
    class NumberViewHolder extends RecyclerView.ViewHolder {

        // Змінні класу - автивні елементи шаблона
        private TextView tvFirst;
        private TextView tvSecond;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            // ініціалізація змінних екземпляра класу
            tvFirst = itemView.findViewById(R.id.tvFirst);
            tvSecond = itemView.findViewById(R.id.tvSecond);

            // Забезпечення роботи слухача по натисненню на елемент --------------------------------
            itemView.setOnClickListener(onItemClickListener);
        }
    }
}
