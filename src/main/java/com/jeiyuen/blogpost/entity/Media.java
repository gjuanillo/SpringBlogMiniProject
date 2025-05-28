package com.jeiyuen.blogpost.entity;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Media{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", nullable = false, updatable = false)
    private UUID uuid;

    @Column(name="file_path", nullable = false)
    private String filePath;

    @ManyToOne
    @JoinColumn(name="blog_details_id", nullable = false)
    private BlogDetails blogDetails;

    public Media() {
    }

    public Media(UUID uuid, String filePath, BlogDetails blogDetails) {
        this.uuid = uuid;
        this.filePath = filePath;
        this.blogDetails = blogDetails;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public BlogDetails getBlogDetails() {
        return blogDetails;
    }

    public void setBlogDetails(BlogDetails blogDetails) {
        this.blogDetails = blogDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, filePath, blogDetails);
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
        Media other = (Media) obj;
        return Objects.equals(uuid, other.uuid) && Objects.equals(filePath, other.filePath)
                && Objects.equals(blogDetails, other.blogDetails);
    }

    @Override
    public String toString() {
        return "Media{uuid=" + uuid + ", filePath=" + filePath + ", blogDetails=" + blogDetails + "}";
    }

}
