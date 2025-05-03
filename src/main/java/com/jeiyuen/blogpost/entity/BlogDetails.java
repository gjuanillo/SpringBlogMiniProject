package com.jeiyuen.blogpost.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="blog_details")
public class BlogDetails{


    @Id
    @Column(name="id", nullable = false, updatable = false)
    private UUID uuid;

    @Column(name="blog_content", length = 5000)
    private String blogContent;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="id")
    private Blogs blogs;

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
    public Blogs getBlogs() {
        return blogs;
    }
    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }
}
