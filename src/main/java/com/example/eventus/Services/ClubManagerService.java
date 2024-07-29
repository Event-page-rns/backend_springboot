package com.example.eventus.Services;

import com.example.eventus.Entities.Club;
import com.example.eventus.Entities.ClubManager;
import com.example.eventus.Repositories.ClubManagerRepository;
import com.example.eventus.Repositories.ClubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClubManagerService {

    private final ClubManagerRepository clubManagerRepository;
    private final ClubRepository clubRepository;

    public ClubManagerService(ClubManagerRepository clubManagerRepository,ClubRepository clubRepository) {
        this.clubManagerRepository = clubManagerRepository;
        this.clubRepository = clubRepository;
    }

    public ResponseEntity<?> addAsClubManager(ClubManager clubManager) {
      try{

          ClubManager clubManager1 = (ClubManager) clubManagerRepository.findByEmail(clubManager.getLogin().getEmail());
          if(clubManager1 != null){
              return ResponseEntity.status(HttpStatus.CREATED).body("User already exists");
          }
          clubManagerRepository.save(clubManager);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }

    }
}
