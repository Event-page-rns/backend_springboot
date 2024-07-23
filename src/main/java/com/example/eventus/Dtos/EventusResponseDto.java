package com.example.eventus.Dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventusResponseDto {

    private Integer eventId;

    private String title;

    private String description;

    private String clubName;

    private LocalDate eventDate;

    private LocalTime eventTime;

    private String eventVenue;

    private double entryFee;

    private double priceMoney;

    private String base32Url;

    private String applyLink;

    private String createdBy;

    private String whatsAppGroupLink;
}
