package com.example.eventus.Controllers;


import com.example.eventus.Entities.ClubManager;
import com.example.eventus.Repositories.ClubRepository;
import com.example.eventus.Services.ClubManagerService;
import com.example.eventus.Services.ClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClubManagerController {

    private final ClubManagerService clubManagerService;

    public ClubManagerController(ClubManagerService clubManagerService) {
        this.clubManagerService = clubManagerService;
    }

    @PostMapping("/addAsClubManager")
    public ResponseEntity<?> addAsClubManager( @RequestBody ClubManager clubManager){
        return clubManagerService.addAsClubManager(clubManager);
    }
}
