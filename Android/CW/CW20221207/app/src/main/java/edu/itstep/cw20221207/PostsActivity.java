package edu.itstep.cw20221207;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private ListView lvPosts;
    private ArrayAdapter<String> adapter;
    private List<String> titles = new ArrayList<>();
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        lvPosts = findViewById(R.id.lvPosts);
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titles
        );
        lvPosts.setOnItemClickListener((adapterView, view, position, id) -> {
            //long userId = posts.get(position);
        });
    }
}
