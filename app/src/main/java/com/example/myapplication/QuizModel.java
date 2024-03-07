package com.example.myapplication;

import java.util.List;

public class QuizModel {
    private String id;
    private String title;
    private String subtitle;
    private String time;

    public QuizModel() {
        this.id = "";
        this.title = "";
        this.subtitle = "";
        this.time = "";
    }

    public QuizModel(String id, String title, String subtitle, String time) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
