package edu.itstep.cw20221207a2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("userId") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private long userId;
    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("id") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private long id;
    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("title") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private String title;
    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("body") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private String body;

    public Post() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
