package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

public class EventUpdate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ManyToOne event;
    private String updateContent;
    private String updateType;
    private LocalDate postedAt;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ManyToOne getEvent() {
        return event;
    }
    public void setEvent(ManyToOne event) {
        this.event = event;
    }
    public String getUpdateContent() {
        return updateContent;
    }
    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }
    public String getUpdateType() {
        return updateType;
    }
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
    public LocalDate getPostedAt() {
        return postedAt;
    }
    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }
    public EventUpdate(ManyToOne event, String updateContent, String updateType, LocalDate postedAt) {
        this.event = event;
        this.updateContent = updateContent;
        this.updateType = updateType;
        this.postedAt = postedAt;
    }
    public EventUpdate() {}
}
