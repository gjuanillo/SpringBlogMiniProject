package com.jeiyuen.blogpost.dto;

public class BlogUpdateDTO{

    private String title;
    private String author;
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
