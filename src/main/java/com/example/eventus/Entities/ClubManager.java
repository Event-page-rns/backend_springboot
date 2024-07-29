package com.example.eventus.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClubManager {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "email")
    private Login login;

    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club;
}
