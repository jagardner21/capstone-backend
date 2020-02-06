package com.Galvanize.capstoneBackend.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

    @Autowired
    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository){ this.eventsRepository = eventsRepository; }

    public List<Event> getAllEvents(){ return this.eventsRepository.findAll(); }

    public Optional<Event> getOneEvent(int id){ return this.eventsRepository.findById(id); }

    public Event addEvent(Event newEvent){ return this.eventsRepository.save(newEvent); }

    public Event updateEvent(Event updatedEvent) { return this.eventsRepository.save(updatedEvent); }

    public String deleteEvent(int id){
        this.eventsRepository.deleteById(id);
        return "Event of ID " + id + " was deleted.";
    }
}
