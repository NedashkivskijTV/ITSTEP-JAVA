package edu.itstep.cw20221201a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    // збереження значень - поля класу
    private int resource;
    private List<Contact> contacts;

    // створення парсера - потребує обов'язкової ініціалізації
    private LayoutInflater inflater;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> contacts) {
        super(context, resource, contacts);

        // збереження даних, що прийшли в конструктор у полях класу
        this.resource = resource;
        this.contacts = contacts;

        // Ініціалізація парсера
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // створення елементів списка за допомогою inflater
        // параметри
        // 1 - як саме виглядатиме елемент списка
        // 2 - інформація про батьківська група елементів - parent - контейнер для усіх елементів списка
        // надходить самостійно у параметрах методу
        // 3 - false (параметр вказує чи потрібно доєднувати елемент корньовий елемент до батька-контейнера, зазвичай встановлюється false)
        // item - контейнер для розміщення елементів, що відображатимуться у кількості, що залежить від розміру колекції
        View item = inflater.inflate(resource, parent, false);

        // Отримання елементів xml-шаблона
        ImageView ivAvatar = item.findViewById(R.id.ivAvatar);
        TextView tvFirstName = item.findViewById(R.id.tvFirstName);
        TextView tvLastName = item.findViewById(R.id.tvLastName);

        // отримання поточного елемента із загальної колекції за позицією
        Contact contact = contacts.get(position);

        // Передача потрібних даних для відображення у відповідних полях шаблона
        ivAvatar.setImageResource(contact.getAvatar());
        tvFirstName.setText(contact.getFirstName());
        tvLastName.setText(contact.getLastName());

        // повернення сформованого елемента
        return item;
        //return super.getView(position, convertView, parent);
    }
}
