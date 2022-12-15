package edu.itstep.cw20221207a2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private Retrofit retrofit; // допомагатиме підключатись до сервера

    // реалізація паттерна Singleton - ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // статична змінна з типом цього ж класу
    private static NetworkService networkService; // null

    // приватний конструктор (щоб унеможливити створення екземпляра класу багато раз - неможливо викликати ззовні)
    private NetworkService(){

        // ініціалізація ретрофіта - для створення використовується паттерн Builder
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com") // URL-адреса сервера до котрого потрібно приєднатись (адреса сторінки, без слеша вкінці)
                .addConverterFactory(GsonConverterFactory.create()) // Додає фабрику, що здійснює конвертування - створення об'єка ,що здійснюватиме перетворення JSON до об'єктів (може бути інший конвертер - XMLConverter)
                .build();
    }

    // Метод, через який отримуватиметься об'єкт класу (через конструктор неможливо)
    public static NetworkService getInstance(){
        if(networkService == null){
            networkService = new NetworkService(); // ініціалізація екземпляра класу у разі відсутності (= null)
        }
        return networkService;
    }
    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    public PlaceholderAPI getApi(){
        return retrofit.create(PlaceholderAPI.class); // звернутись до об’єкта retrofit з командою створити реалізацію Інтерфейса PlaceholderAPI
    }
}
