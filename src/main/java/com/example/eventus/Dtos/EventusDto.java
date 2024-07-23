package com.example.eventus.Dtos;


import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventusDto {

    private String title;

    private String description;

    private String clubName;

    private LocalDate eventDate;

    private LocalTime eventTime;

    private String eventVenue;

    private double entryFee;

    private double priceMoney;

    private String base32Url;

    private String createdBy;

    private String applyLink;

    private String whatsAppGroupLink;

}
