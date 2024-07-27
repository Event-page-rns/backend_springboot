package com.example.eventus.Controllers;


import com.example.eventus.Dtos.EventusDto;
import com.example.eventus.Dtos.EventusResponseDto;
import com.example.eventus.Services.EventusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class EventusController {


    private final EventusService eventusService;

    public EventusController(EventusService eventusService){
        this.eventusService  = eventusService;
    }

    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@RequestBody EventusDto eventusDto){
        return eventusService.addEvent(eventusDto);
    }

    @GetMapping("/events")
    public List<EventusResponseDto> getAllEvents(){
        return eventusService.getAllEvents();
    }

    @PostMapping("/events/update/{event-id}")
    public ResponseEntity<?> updateTask(@PathVariable("event-id") long eventId,@RequestBody EventusDto eventusDto){
        return eventusService.updateEvent(eventId,eventusDto);
    }

    @DeleteMapping("/events/delete/{event-id}")
    public ResponseEntity<?> deleteTask(@PathVariable("event-id") long eventId){
        return eventusService.deleteEvent(eventId);
    }




}
