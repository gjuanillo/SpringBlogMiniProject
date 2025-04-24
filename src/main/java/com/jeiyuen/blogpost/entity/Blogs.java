package com.jeiyuen.blogpost.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="blogs")
public class Blogs{

    //Declare Attributes/Fields
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", nullable = false, updatable = false)
    private UUID uuid;

    @Column(name="title", nullable= false)
    private String title;
    
    @Column(name="author", nullable = false)
    private String author;
    
    @OneToOne(mappedBy="blogs", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private BlogDetails blogDetails;

    @Column(name="creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name="updated", nullable = false)
    private LocalDateTime updated;

    //Constructors
    public Blogs() {
    }
    public Blogs(UUID uuid, String title, String author, LocalDateTime creationDate, LocalDateTime updated) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.updated = updated;
    }

    //Getters and Setters
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
    
    //To String
    @Override
    public String toString() {
        return "Blogs{uuid=" + uuid + ", title=" + title + ", author=" + author + ", creationDate=" + creationDate
                + ", updated=" + updated + "}";
    }
    @Override
    public int hashCode() {
        return Objects.hash(uuid, title, author, creationDate, updated);
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
        Blogs other = (Blogs) obj;
        return Objects.equals(uuid, other.uuid) && Objects.equals(title, other.title)
                && Objects.equals(author, other.author) && Objects.equals(creationDate, other.creationDate)
                && Objects.equals(updated, other.updated);
    }

  }
