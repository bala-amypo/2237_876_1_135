package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "broadcast_logs")
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_update_id")
    private EventUpdate eventUpdate;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private User subscriber;

    private String deliveryStatus = "SENT";

    private Timestamp sentAt;

    public BroadcastLog() {}

    public BroadcastLog(EventUpdate eventUpdate, User subscriber, String deliveryStatus) {
        this.eventUpdate = eventUpdate;
        this.subscriber = subscriber;
        this.deliveryStatus = deliveryStatus;
    }

    @PrePersist
    protected void onCreate() {
        this.sentAt = new Timestamp(System.currentTimeMillis());
    }
    public User getSubscriber() {
        return subscriber;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

}
