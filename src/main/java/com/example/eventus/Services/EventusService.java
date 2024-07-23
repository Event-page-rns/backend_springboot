package com.example.eventus.Services;

import com.example.eventus.Dtos.EventusDto;
import com.example.eventus.Dtos.EventusResponseDto;
import com.example.eventus.Entities.Eventus;
import com.example.eventus.Mappings.EventsusMapping;
import com.example.eventus.Repositories.EventusRepository;
import com.example.eventus.Responses.EventusResponses;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EventusService {

    private final EventusRepository eventusRepository;
    private final EventsusMapping eventsusMapping;

    public EventusService(EventusRepository eventusRepository, EventsusMapping eventsusMapping) {
        this.eventusRepository = eventusRepository;
        this.eventsusMapping = eventsusMapping;
    }

    @Transactional
    public ResponseEntity<EventusResponses> addEvent(EventusDto eventusDto) {
        try {
            Eventus eventus = eventsusMapping.MapEventusDtoToEventus(eventusDto);
            eventusRepository.save(eventus);
            EventusResponses response = new EventusResponses("Event successfully created", true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            EventusResponses response = new EventusResponses("Failed to create event: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public List<EventusResponseDto> getAllEvents() {
        List<Eventus> eventResponse= eventusRepository.findAll();
        return eventResponse
                .stream()
                .map(eventsusMapping::MapEventusToEventusResponseDto)
                .toList();
    }

//    public ResponseEntity<?> updateEvent(long eventId, EventusDto eventusDto) {
//        Eventus eventResponse = eventusRepository.findById(eventId)
//                .orElseThrow(() -> new RuntimeException(("Event not found")));
//
//        eventResponse.setTitle(eventusDto.getTitle());
//        eventResponse.setDescription(eventusDto.getDescription());
//        eventResponse.setClubName(eventusDto.getClubName());
//        eventResponse.setEventDate(eventusDto.getEventDate());
//        eventResponse.setEventTime(eventusDto.getEventTime());
//        eventResponse.setEventVenue(eventusDto.getEventVenue());
//        eventResponse.setEntryFee(eventusDto.getEntryFee());
//        eventResponse.setPriceMoney(eventusDto.getPriceMoney());
//        eventResponse.setBase32Url(eventusDto.getBase32Url());
//        eventResponse.setApplyLink(eventusDto.getApplyLink());
//        eventResponse.setCreatedBy(eventusDto.getCreatedBy());
//        eventResponse.setWhatsAppGroupLink(eventusDto.getWhatsAppGroupLink());
//
//        return ResponseEntity.ok(new EventusResponses("Task updated successfully",true));
//    }

    public ResponseEntity<EventusResponses> updateEvent(long eventId, EventusDto eventusDto) {
        Optional<Eventus> optionalEvent = eventusRepository.findById(eventId);
        if (optionalEvent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new EventusResponses("Event not found", false));
        }

        Eventus event = optionalEvent.get();
        updateEventDetails(event, eventusDto);
        eventusRepository.save(event);

        return ResponseEntity.ok(new EventusResponses("Event updated successfully", true));
    }

    private void updateEventDetails(Eventus event, EventusDto eventusDto) {
        event.setTitle(eventusDto.getTitle());
        event.setDescription(eventusDto.getDescription());
        event.setClubName(eventusDto.getClubName());
        event.setEventDate(eventusDto.getEventDate());
        event.setEventTime(eventusDto.getEventTime());
        event.setEventVenue(eventusDto.getEventVenue());
        event.setEntryFee(eventusDto.getEntryFee());
        event.setPriceMoney(eventusDto.getPriceMoney());
        event.setBase32Url(eventusDto.getBase32Url());
        event.setApplyLink(eventusDto.getApplyLink());
        event.setWhatsAppGroupLink(eventusDto.getWhatsAppGroupLink());
        // Assuming createdBy is not updated. If it should be, include it here.
    }


    @Transactional
    public ResponseEntity<EventusResponses> deleteEvent(long eventId) {
        if (!eventusRepository.existsById(eventId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new EventusResponses("Event not found", false));
        }
        eventusRepository.deleteById(eventId);
        return ResponseEntity.ok(new EventusResponses("Event deleted successfully", true));
    }
}
