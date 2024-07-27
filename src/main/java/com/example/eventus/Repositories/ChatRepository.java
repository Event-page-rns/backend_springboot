package com.example.eventus.Repositories;

import com.example.eventus.Entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Long> {
}
