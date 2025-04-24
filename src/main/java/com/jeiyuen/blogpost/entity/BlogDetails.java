package com.jeiyuen.blogpost.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="blog-details")
public class BlogDetails{


    @Id
    @Column(name="id", nullable = false, updatable = false)
    private UUID uuid;

    @Column(name="blog-content")
    private String blogContent;

    public BlogDetails(){}
    public BlogDetails(UUID uuid, String blogContent) {
        this.uuid = uuid;
        this.blogContent = blogContent;
    }

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getBlogContent() {
        return blogContent;
    }
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

}
