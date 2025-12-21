package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private Instant subscribedAt;

    @PrePersist
    public void onCreate() {
        this.subscribedAt = Instant.now();
    }

    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public Instant getSubscribedAt() { return subscribedAt; }

    public Subscription(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public Subscription() {
    }

    
}
