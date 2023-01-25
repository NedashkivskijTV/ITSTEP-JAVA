package edu.itstep.fullstackclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.0.109:8080/";
    // Налаштування базового URL -
    // В дані адресі неможливо вказати адресу локального хоста, оскільки у емулятора телефону також є власний localhost
    // тому за таким url телефон звертатиметься до власного локального хоста
    // Для вказання адреси, на яку має звернутись телефон потрібна локальна IP-адреса комп'ютера
    // Для отртмання локального IP:
    // Window+R
    // cmd
    // у рядку консолі виконати команду ipconfig
    // один з розділів відображеної інформації міститиме дані про Адаптер беспроводной локальной сети Беспроводная сеть та IPv4-адрес
    // у даному випадку 192.168.0.109 - потрібно вказати його після http://
    // після IP вписати номер порта підключення після : та завершити рядок /
    // в результаті має вийти подібний рядок - "http://192.168.0.109:8080/"

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance(){
        if(networkService == null){
            networkService = new NetworkService();
        }
        return networkService;
    }

    public EmployeeApi getEmployeeApi(){
        return retrofit.create(EmployeeApi.class);
    }

}
