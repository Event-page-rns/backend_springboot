package com.example.eventus.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventusResponseDto {

    private Integer eventId;

    private String title;

    private String description;

    private String clubName;

    private String eventDate;
    // private LocalDate eventDate;

    private String eventTime;
    // private LocalTime eventTime;

    private String eventVenue;

    private String entryFee;
    // private double entryFee;

    private String priceMoney;
    // private double priceMoney;

    private String base32Url;

    private String applyLink;

    private String createdBy;

    private String whatsAppGroupLink;
}
