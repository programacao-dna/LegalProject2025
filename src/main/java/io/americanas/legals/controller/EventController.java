package io.americanas.legals.controller;

import io.americanas.legals.model.Event;
import io.americanas.legals.service.EventService;
import io.americanas.legals.response.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event newEvent) {
        eventService.addNewEvent(newEvent);
        return eventService.addNewEvent(newEvent);
    }

    @GetMapping
    public ResponseEntity<ModelResponse> getAllEvents() {
        ModelResponse response = new ModelResponse(
                "Lista de eventos",
                HttpStatus.ACCEPTED,
                LocalDateTime.now(),
                eventService.getAllEvents(),
                eventService.getAllEvents().size()
        );
        return ResponseEntity.status(202).body(response);
    }

    @GetMapping("/{prettyName}")
    public ResponseEntity<ModelResponse> getEventByPrettyName(@PathVariable String prettyName) {
        Event event = eventService.getByPrettyName(prettyName);
        if (event != null) {
            ModelResponse response = new ModelResponse(
                    "Evento localizado com sucesso: " + prettyName,
                    HttpStatus.ACCEPTED,
                    LocalDateTime.now(),
                    event,
                    1
            );
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            ModelResponse response = new ModelResponse(
                    "Evento não localizado com sucesso: " + prettyName,
                    HttpStatus.NOT_FOUND,
                    LocalDateTime.now(),
                    null,
                    0
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/ordened")
    public ResponseEntity<ModelResponse> getAllEventsOrdened() {

//        List<Event> events = eventService.getAllEvents().stream()
//                .sorted((loc1, loc2) -> loc1.getLocation().compareTo(loc2.getLocation()))
//                .toList();

        List<Event> events = eventService.getAllEvents().stream()
                .sorted((loc1, loc2) -> Double.compare(loc1.getPrice(), loc2.getPrice()))
                .filter(event -> event.getPrice() == 0)
                .toList();

        ModelResponse response = new ModelResponse(
                "Lista de eventos",
                HttpStatus.ACCEPTED,
                LocalDateTime.now(),
                events,
                events.size()
        );
        return ResponseEntity.status(202).body(response);
    }
}
