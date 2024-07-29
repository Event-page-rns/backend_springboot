package com.example.eventus.Services;

import com.example.eventus.Dtos.LoginDto;
import com.example.eventus.Dtos.LoginResponseDto;
import com.example.eventus.Entities.ClubManager;
import com.example.eventus.Entities.Login;
import com.example.eventus.Mappings.LoginMapping;
import com.example.eventus.Repositories.ClubManagerRepository;
import com.example.eventus.Repositories.LoginRepository;
import com.example.eventus.Responses.LoginResponses;
import com.example.eventus.Responses.RegisterResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final LoginMapping loginMapping;
    private final ClubManagerRepository clubManagerRepository;


    public LoginService(LoginRepository loginRepository, LoginMapping loginMapping,ClubManagerRepository clubManagerRepository) {
        this.loginRepository = loginRepository;
        this.loginMapping = loginMapping;
        this.clubManagerRepository = clubManagerRepository;
    }

    @Transactional
    public ResponseEntity<?> register(LoginDto dto) {
        Login user = loginRepository.findByEmail(dto.getEmail());
        if(user == null) {
            Login user1 = loginMapping.MapLoginDtoToLogin(dto);
            loginRepository.save(user1);
            RegisterResponse response = new RegisterResponse("Register successful", true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        else {
            RegisterResponse response = new RegisterResponse("User already exists", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @Transactional
    public ResponseEntity<?> login(LoginDto dto) {
        Login user = loginRepository.findByEmail(dto.getEmail());
        if(user == null) {
            LoginResponses response = new LoginResponses("User not found.","student",false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        else {
            if(!user.getPassword().equals(dto.getPassword())) {
                RegisterResponse response = new RegisterResponse("Invalid Password", false);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            ClubManager clubManager = (ClubManager) clubManagerRepository.findByEmail(dto.getEmail());
            if(clubManager != null){
                LoginResponses responses = new LoginResponses("Login Successful","manager",true);
                return ResponseEntity.status(HttpStatus.OK).body(responses);
            }

            LoginResponses responses = new LoginResponses("Login Successful","student",true);
            return ResponseEntity.status(HttpStatus.OK).body(responses);
        }
    }

    public List<LoginResponseDto> getAllUser() {
        List<Login> users = loginRepository.findAll();
        return users.stream()
                .map(login -> loginMapping.MapLoginToLoginResponseDto(login, "verified"))
                .toList();
    }
}
