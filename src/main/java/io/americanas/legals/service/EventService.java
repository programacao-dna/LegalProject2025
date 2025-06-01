package io.americanas.legals.service;

import io.americanas.legals.model.Event;
import io.americanas.legals.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event addNewEvent(Event event) {
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));
        return repository.save(event);
    }

    public List<Event> getAllEvents() {
        return (List<Event>) repository.findAll();
    }

    public Event getEventById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Event getByPrettyName(String prettyName) {
        return repository.findByPrettyName(prettyName);
    }
}
