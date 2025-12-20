package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
public class EventUpdate {
    @Id
    private Long id;
    private Event event;
    private Instant timestamp;
    private SeverityLevel severityLevel;

    public void onCreate() {
        this.timestamp = Instant.now();
        if (this.severityLevel == null) {
            this.severityLevel = SeverityLevel.LOW;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public Instant getTimestamp() { return timestamp; }

    public SeverityLevel getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }
}
