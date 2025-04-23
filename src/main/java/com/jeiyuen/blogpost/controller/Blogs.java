package com.jeiyuen.blogpost.controller;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="blogs")
public class Blogs{

    //Declare Attributes/Fields
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", nullable = false, updatable = false)
    private String uuid;

    @Column(name="title", nullable= false)
    private String title;
    
    @Column(name="author", nullable = false)
    private String author;

    @Column(name="creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name="updated", nullable = false)
    private LocalDateTime updated;

    public String getUuid() {
        return uuid;
    }

    //Constructors
    public Blogs(){}
    public Blogs(String uuid, String title, String author, LocalDateTime creationDate, LocalDateTime updated) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.updated = updated;
    }

    //Getters and Setters
    public void setUuid(String uuid) {
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
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Blogs{uuid=" + uuid + ", title=" + title + ", author=" + author + ", creationDate=" + creationDate
                + ", updated=" + updated + ", getUuid()=" + getUuid() + "}";
    }

}
