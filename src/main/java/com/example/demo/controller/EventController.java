package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.service.EventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PreAuthorize("hasAnyRole('PUBLISHER','ADMIN')")
    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PreAuthorize("hasAnyRole('PUBLISHER','ADMIN')")
    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @PreAuthorize("hasAnyRole('PUBLISHER','ADMIN')")
    @GetMapping("/{id}")
    public Event get(@PathVariable Long id) {
        return eventService.getById(id);
    }

    @PreAuthorize("hasAnyRole('PUBLISHER','ADMIN')")
    public List<Event> getActive() {
        return eventService.getActiveEvents();
    }

    @PreAuthorize("hasAnyRole('PUBLISHER','ADMIN')")
    @PatchMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        eventService.deactivateEvent(id);
    }
}
