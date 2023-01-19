package edu.itstep.cw20230118client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private Retrofit retrofit;
    private static NetworkService networkService;
    private static final String BASE_URL = "http://192.168.0.109:8080/";

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

    public EmployeeApi getApi(){
        return retrofit.create(EmployeeApi.class);
    }
}
