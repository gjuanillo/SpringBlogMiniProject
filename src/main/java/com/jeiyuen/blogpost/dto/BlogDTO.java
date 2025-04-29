package com.jeiyuen.blogpost.dto;

import java.util.UUID;

public class BlogDTO {

    private UUID uuid;
    private String title;
    private String author;
    private String blogContent;

    public BlogDTO() {
    }

    public BlogDTO(UUID uuid, String title, String author, String blogContent) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.blogContent = blogContent;
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

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

}
