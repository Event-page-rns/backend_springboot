package com.example.eventus.Services;

import com.example.eventus.Entities.Club;
import com.example.eventus.Repositories.ClubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ClubService {

    private final ClubRepository clubRepository;

   ClubService(ClubRepository clubRepository){
       this.clubRepository = clubRepository;

   }

    public ResponseEntity<?> addClub(Club club) {
       try{
           clubRepository.save(club);
           return ResponseEntity.status(HttpStatus.CREATED).body("Club added Successfully");
       }catch (Exception e){
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
       }
    }
}
