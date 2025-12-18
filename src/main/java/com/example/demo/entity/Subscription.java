package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

public class Subscription
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ManyToOne user;
    private ManyToOne event;
    private LocalDate subscribedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ManyToOne getUser() {
        return user;
    }
    public void setUser(ManyToOne user) {
        this.user = user;
    }
    public ManyToOne getEvent() {
        return event;
    }
    public void setEvent(ManyToOne event) {
        this.event = event;
    }
    public LocalDate getSubscribedAt() {
        return subscribedAt;
    }
    public void setSubscribedAt(LocalDate subscribedAt) {
        this.subscribedAt = subscribedAt;
    }
    public Subscription(ManyToOne user, ManyToOne event, LocalDate subscribedAt) {
        this.user = user;
        this.event = event;
        this.subscribedAt = subscribedAt;
    }
    public Subscription() {}
}
