package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    EventUpdate createUpdate(Long eventId, EventUpdate update);

    EventUpdate publishUpdate(EventUpdate update);

    List<EventUpdate> getUpdatesForEvent(Long eventId);

    EventUpdate getUpdateById(Long id);
}
