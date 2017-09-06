package com.example.ducviet.demoretrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ducviet.demoretrofit.R;
import com.example.ducviet.demoretrofit.manager.ApiService;
import com.example.ducviet.demoretrofit.manager.RecyclerPostAdapter;
import com.example.ducviet.demoretrofit.manager.ServiceGenerator;
import com.example.ducviet.demoretrofit.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Post> arrayList;
    private RecyclerPostAdapter adapter;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rec_post);
        recyclerView.setHasFixedSize(true);
        manager = new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(manager);
        arrayList = new ArrayList<>();

        ApiService service = ServiceGenerator.createService(ApiService.class);
        service.getAllPost().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if(response!=null){
                    arrayList = response.body();
                    adapter = new RecyclerPostAdapter(MainActivity.this,arrayList);
                    recyclerView.setAdapter(adapter);
                    Log.e("Erro ", "onFailure: "+" connect" );

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                Log.e("Erro ", "onFailure: "+"not connect" );
            }
        });
    }
}
