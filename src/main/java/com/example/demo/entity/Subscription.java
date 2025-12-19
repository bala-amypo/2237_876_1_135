package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "subscriptions",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "event_id"}))
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private Timestamp subscribedAt;

    public Subscription() {}

    public Subscription(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    @PrePersist
    protected void onCreate() {
        this.subscribedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id){
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

}
