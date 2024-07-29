package com.example.eventus.Repositories;

import com.example.eventus.Entities.ClubManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClubManagerRepository extends JpaRepository<ClubManager,Long> {
    @Query("SELECT cm FROM ClubManager cm WHERE cm.login.email = :email")
    ClubManager findByEmail(@Param("email") String email);
}
