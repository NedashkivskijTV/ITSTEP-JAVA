package edu.itstep.cw20230111a;

import android.app.Application;

import androidx.room.Room;

public class App extends Application { // клас, що реалізує паттерн Singleton для сутності AppDatabase (конфігурації БД)

    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() { // спрацьовує при запуску додатка
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "it-company").allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}