package com.Galvanize.capstoneBackend.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private final EventsService eventsService;

    public EventsController(EventsService eventsService) { this.eventsService = eventsService; }

    @GetMapping
    public List<Event> getAllEvents() { return this.eventsService.getAllEvents(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Event> getOneEvent(@PathVariable int id) { return this.eventsService.getOneEvent(id); }

   @PostMapping
   public Event addEvent(@RequestBody Event newEvent){ return this.eventsService.addEvent(newEvent); }

   @PatchMapping
    public Event updateEvent(@RequestBody Event updatedEvent){
        Event event = eventsService.getOneEvent(updatedEvent.getId()).orElseThrow(IllegalArgumentException::new);
        return this.eventsService.updateEvent(updatedEvent);
   }

   @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable int id){
        Event event = eventsService.getOneEvent(id).orElseThrow(IllegalArgumentException::new);
        return eventsService.deleteEvent(id);
   }

}
