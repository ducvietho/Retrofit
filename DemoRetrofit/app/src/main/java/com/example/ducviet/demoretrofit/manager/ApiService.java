package com.example.ducviet.demoretrofit.manager;

import com.example.ducviet.demoretrofit.model.Post;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ducviet on 31/08/2017.
 */

public interface ApiService {
    @GET("/users/mobilesiri/followers")
    Call<ArrayList<Post>> getAllPost();
}
