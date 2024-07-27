package com.example.eventus.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Eventus {

    @Id
    @GeneratedValue
    private Integer eventId;

    @Column(
            name="e_title",
            nullable = false
    )
    private String title;

    @Column(
            name="e_description",
            length = 20000,
            nullable = false
    )
    private String description;

    @Column(
            name="club_name",
            nullable = false
    )
    private String clubName;

    @Column(
            name="e_date",
            nullable = false
    )
    private String eventDate;
    // private LocalDate eventDate;

    @Column(
            name = "e_time",
            nullable = false
    )
    private String eventTime;
    // private LocalTime eventTime;

    @Column(
            name="e_venue"
    )
    private String eventVenue;

    @Column(
            name = "entry_fee"
    )
    private String entryFee;
    // private double entryFee;

    @Column(
            name = "price_money"
    )
    private String priceMoney;
    // private double priceMoney;

    @Column(
            name = "img_url",
            length = 1000000000,
            nullable = false
    )
    private String base32Url;

    @Column(
            name = "apply_link"
    )
    private String applyLink;

    @Column(
            name = "created_by"
    )
    private String createdBy;

    @Column(
            name = "group_link"
    )
    private String whatsAppGroupLink;
}
