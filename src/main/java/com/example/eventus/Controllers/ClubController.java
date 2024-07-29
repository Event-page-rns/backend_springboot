package com.example.eventus.Controllers;

import com.example.eventus.Entities.Club;
import com.example.eventus.Services.ClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/addClub")
    public ResponseEntity<?> addClub(@RequestBody Club club){
        return clubService.addClub(club);
    }

}
