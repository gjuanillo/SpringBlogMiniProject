package com.jeiyuen.blogpost.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDTO {

    private UUID uuid;
    @NotBlank(message = "Title is required!")
    @Size(max = 100, message = "Title cannot be longer than 100 characters!")
    private String title;
    @NotBlank(message="Author is required!")
    @Size(max= 50, message = "Author cannot be longer than 50 characters!")
    private String author;
    @NotBlank(message="Content cannot be empoty!")
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
