package com.example.recyclerviewdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Todo {
    private static int lastId = 0;
        @SerializedName("userId")
    @Expose
    private Integer userId;
        @SerializedName("id")
    @Expose
    private Integer id;
        @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("completed")
    @Expose
    private Boolean completed;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    Todo(String title) {
        this.title = title;
    }

    public static ArrayList<Todo> createSampleTodo(int num) {
        ArrayList<Todo> todoList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            todoList.add(new Todo("Todo " + i));
        }
        return todoList;
    }

}