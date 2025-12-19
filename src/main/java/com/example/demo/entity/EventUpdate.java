package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "event_updates")
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String updateContent;
    private String updateType;

    private Timestamp postedAt;

    @OneToMany(mappedBy = "eventUpdate")
    private List<BroadcastLog> broadcastLogs;

    public EventUpdate() {}

    public EventUpdate(Event event, String updateContent, String updateType) {
        this.event = event;
        this.updateContent = updateContent;
        this.updateType = updateType;
    }

    @PrePersist
    protected void onCreate() {
        this.postedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) {
        this.event = event;
    }

}
