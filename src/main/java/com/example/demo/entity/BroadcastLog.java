package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

public class Subscription
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ManyToOne eventUpdate;
    private ManyToOne subscriber;
    private String deliveryStatus;
    private LocalDate sentAt;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ManyToOne getEventUpdate() {
        return eventUpdate;
    }
    public void setEventUpdate(ManyToOne eventUpdate) {
        this.eventUpdate = eventUpdate;
    }
    public ManyToOne getSubscriber() {
        return subscriber;
    }
    public void setSubscriber(ManyToOne subscriber) {
        this.subscriber = subscriber;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public LocalDate getSentAt() {
        return sentAt;
    }
    public void setSentAt(LocalDate sentAt) {
        this.sentAt = sentAt;
    }
    public Subscription(ManyToOne eventUpdate, ManyToOne subscriber, String deliveryStatus, LocalDate sentAt) {
        this.eventUpdate = eventUpdate;
        this.subscriber = subscriber;
        this.deliveryStatus = deliveryStatus;
        this.sentAt = sentAt;
    }
    public Subscription() {}
}
