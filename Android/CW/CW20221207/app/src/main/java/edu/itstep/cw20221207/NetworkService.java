package edu.itstep.cw20221207;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private Retrofit retrofit;
    private static NetworkService networkService;//null

    private NetworkService(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (networkService == null) {
            networkService = new NetworkService();
        }
        return networkService;
    }

    public PlaceholderAPI getApi(){
        return retrofit.create(PlaceholderAPI.class);
    }

}
