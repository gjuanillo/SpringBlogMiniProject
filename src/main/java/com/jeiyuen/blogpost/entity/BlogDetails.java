package com.jeiyuen.blogpost.entity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="blog_details")
public class BlogDetails{


    @Id
    @Column(name="id", nullable = false, updatable = false)
    private UUID uuid;

    @Lob
    @Column(name="blog_content", columnDefinition = "TEXT")
    private String blogContent;

    // Enable users to have the ability to add multiple media files
    @OneToMany(mappedBy = "blogDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> medias;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="id")
    private Blogs blogs;

    public BlogDetails(){}
    public BlogDetails(UUID uuid, String blogContent, List<Media> medias, Blogs blogs) {
        this.uuid = uuid;
        this.blogContent = blogContent;
        this.medias = medias;
        this.blogs = blogs;
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
    public List<Media> getMedias() {
        return medias;
    }
    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }
    public Blogs getBlogs() {
        return blogs;
    }
    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, blogContent, medias, blogs);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BlogDetails other = (BlogDetails) obj;
        return Objects.equals(uuid, other.uuid) && Objects.equals(blogContent, other.blogContent)
                && Objects.equals(medias, other.medias) && Objects.equals(blogs, other.blogs);
    }

    @Override
    public String toString() {
        return "BlogDetails{uuid=" + uuid + ", blogContent=" + blogContent + ", medias=" + medias + ", blogs=" + blogs
                + "}";
    }

}
