package com.example.eventus.Mappings;

import com.example.eventus.Dtos.EventusDto;
import com.example.eventus.Dtos.EventusResponseDto;
import com.example.eventus.Entities.Eventus;
import org.springframework.stereotype.Component;


@Component
public class EventsusMapping {


    public Eventus MapEventusDtoToEventus(EventusDto eventusDto){
        Eventus eventus = new Eventus();
        eventus.setTitle(eventusDto.getTitle());
        eventus.setDescription(eventusDto.getDescription());
        eventus.setClubName(eventusDto.getClubName());
        eventus.setEventDate(eventusDto.getEventDate());
        eventus.setEventTime(eventusDto.getEventTime());
        eventus.setEventVenue(eventusDto.getEventVenue());
        eventus.setEntryFee(eventusDto.getEntryFee());
        eventus.setPriceMoney(eventusDto.getPriceMoney());
        eventus.setBase32Url(eventusDto.getBase32Url());
        eventus.setApplyLink(eventusDto.getApplyLink());
        eventus.setCreatedBy(eventusDto.getCreatedBy());
        eventus.setWhatsAppGroupLink(eventusDto.getWhatsAppGroupLink());

        return eventus;
    }


    public EventusResponseDto MapEventusToEventusResponseDto(Eventus eventus){
        EventusResponseDto eventusResponseDto = new EventusResponseDto();
        eventusResponseDto.setEventId(eventus.getEventId());
        eventusResponseDto.setTitle(eventus.getTitle());
        eventusResponseDto.setDescription(eventus.getDescription());
        eventusResponseDto.setClubName(eventus.getClubName());
        eventusResponseDto.setEventDate(eventus.getEventDate());
        eventusResponseDto.setEventTime(eventus.getEventTime());
        eventusResponseDto.setEventVenue(eventus.getEventVenue());
        eventusResponseDto.setEntryFee(eventus.getEntryFee());
        eventusResponseDto.setPriceMoney(eventus.getPriceMoney());
        eventusResponseDto.setBase32Url(eventus.getBase32Url());
        eventusResponseDto.setApplyLink(eventus.getApplyLink());
        eventusResponseDto.setCreatedBy(eventus.getCreatedBy());
        eventusResponseDto.setWhatsAppGroupLink(eventus.getWhatsAppGroupLink());

        return eventusResponseDto;
    }


}
