package com.jeiyuen.blogpost.dto;

import jakarta.validation.constraints.Size;

public class BlogUpdateDTO{

    @Size(max = 100, message = "Title cannot exceed 100 characters!")
    private String title;
    @Size(max = 50, message = "Author cannot exceed 50 characters!")
    private String author;
    @Size(max = 5000, message = "Content is too long!")
    private String blogContent;

    public BlogUpdateDTO() {
    }
    public BlogUpdateDTO(String title, String author, String blogContent) {
        this.title = title;
        this.author = author;
        this.blogContent = blogContent;
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
