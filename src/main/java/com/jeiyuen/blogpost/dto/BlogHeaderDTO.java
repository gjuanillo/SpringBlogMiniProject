package com.jeiyuen.blogpost.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class BlogHeaderDTO{
    private UUID uuid;
    private String title;
    private String author;
    private LocalDateTime created;
    private LocalDateTime updated;

    public BlogHeaderDTO() {
    }
    public BlogHeaderDTO(UUID uuid, String title, String author, LocalDateTime created, LocalDateTime updated) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.created = created;
        this.updated = updated;
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
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

}
