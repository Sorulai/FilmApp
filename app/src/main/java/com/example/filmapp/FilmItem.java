package com.example.filmapp;

public class FilmItem {
    private String title;
    private String description;
    private String id;
    private String fav_status;
    private int imageRes;

    public FilmItem() {
    }

    public FilmItem(String title, String description, String id, String fav_status, int imageRes) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.fav_status = fav_status;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFav_status() {
        return fav_status;
    }

    public void setFav_status(String fav_status) {
        this.fav_status = fav_status;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
