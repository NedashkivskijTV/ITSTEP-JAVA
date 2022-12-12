package edu.itstep.cw20221207;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaceholderAPI {

    @GET("/posts")
    Call<List<Post>> getAllPosts();

    @GET("/posts/{id}")
    Call<Post>getPostById(@Path("id")long postId);
}
