package com.example.recyclerviewdemo;

import com.example.recyclerviewdemo.model.Photo;
import com.example.recyclerviewdemo.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/todos")
    Call<List<Todo>> getAllTodos();

    @GET("/photos")
    Call<List<Photo>> getAllPhotos();
}
