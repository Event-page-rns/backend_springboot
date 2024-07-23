package com.example.eventus.Repositories;

import com.example.eventus.Entities.Eventus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventusRepository extends JpaRepository<Eventus,Long> {
}
