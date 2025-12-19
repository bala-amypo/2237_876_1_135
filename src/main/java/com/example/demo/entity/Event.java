package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;

    private Boolean isActive = true;

    private Timestamp createdAt;

    @OneToMany(mappedBy = "event")
    private List<EventUpdate> updates;

    @OneToMany(mappedBy = "event")
    private List<Subscription> subscriptions;

    public Event() {}

    public Event(String title, String description, String location, String category, User publisher) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.isActive = true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

}
