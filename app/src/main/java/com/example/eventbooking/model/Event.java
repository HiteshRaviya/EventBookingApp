package com.example.eventbooking.model;

import java.io.Serializable;

public class Event implements Serializable {
    private String title;
    private String description;
    private int imageResId;

    public Event(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
