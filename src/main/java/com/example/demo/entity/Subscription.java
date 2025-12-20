package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
public class Subscription {
    @Id
    private Long id;
    private User user;
    private Event event;
    private Instant subscribedAt;

    public void onCreate() {
        this.subscribedAt = Instant.now();
    }

    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public Instant getSubscribedAt() { return subscribedAt; }
}