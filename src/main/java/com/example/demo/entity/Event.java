package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;
    private ManyToOne publisher;
    private Boolean isActive = true;
    private LocalDate createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public ManyToOne getPublisher() {
        return publisher;
    }
    public void setPublisher(ManyToOne publisher) {
        this.publisher = publisher;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public Event(String title, String description, String location, String category, ManyToOne publisher,
            Boolean isActive, LocalDate createdAt) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }
    public Event() {}
}
