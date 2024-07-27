package com.example.eventus.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue
    private Integer messageId;

    @Column(length = 5000)
    private String message;

    private String email;

    private String Date;

    private String time;
}
