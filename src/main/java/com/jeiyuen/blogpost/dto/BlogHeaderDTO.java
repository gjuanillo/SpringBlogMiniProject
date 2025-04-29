package com.jeiyuen.blogpost.dto;

import java.util.UUID;

public class BlogHeaderDTO{
    private UUID uuid;
    private String title;
    private String author;

    public BlogHeaderDTO() {
    }
    public BlogHeaderDTO(UUID uuid, String title, String author) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
    }

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

}
