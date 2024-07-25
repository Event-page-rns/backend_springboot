package com.example.eventus.Repositories;

import com.example.eventus.Entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {


    Login findByEmail(String email);
}
