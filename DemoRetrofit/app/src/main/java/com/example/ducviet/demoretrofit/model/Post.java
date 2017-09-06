package com.example.ducviet.demoretrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ducviet on 31/08/2017.
 */

public class Post {
    @SerializedName("id")
    private String id;

    public Post(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
