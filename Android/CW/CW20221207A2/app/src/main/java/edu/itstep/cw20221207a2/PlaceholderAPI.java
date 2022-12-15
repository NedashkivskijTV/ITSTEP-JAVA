package edu.itstep.cw20221207a2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaceholderAPI {

    @GET("/posts") // вказує який саме запит викликатиме даний метод
    Call<List<Post>> getAllPosts(); // отримання усіх постів


    @GET("/posts/{id}") // вказує який саме запит викликатиме даний метод
    Call<Post> getPostById(@Path("id")long postId); // отримання поста за id
    // @Path("id") - зв'язує параметр та змінну у анотації, що визначає вид запиту -
    // для передачі id з параметрів методу до запиту

}
