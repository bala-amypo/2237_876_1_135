package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        User publisher = event.getPublisher();
        if (publisher == null ||
            !(publisher.getRole().equals("PUBLISHER") || publisher.getRole().equals("ADMIN"))) {
            throw new IllegalArgumentException("Invalid publisher role");
        }

        event.setIsActive(true);
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event updated) {
        Event event = getEventById(id);

        event.setIsActive(updated.getIsActive());
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<Event> getActiveEvents() {
        return eventRepository.findByIsActiveTrue();
    }

    @Override
    public Event deactivateEvent(Long id) {
        Event event = getEventById(id);
        event.setIsActive(false);
        return eventRepository.save(event);
    }
}
