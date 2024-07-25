package com.example.eventus.Services;

import com.example.eventus.Dtos.LoginDto;
import com.example.eventus.Dtos.LoginResponseDto;
import com.example.eventus.Entities.Login;
import com.example.eventus.Mappings.LoginMapping;
import com.example.eventus.Repositories.LoginRepository;
import com.example.eventus.Responses.LoginResponses;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final LoginMapping loginMapping;


    public LoginService(LoginRepository loginRepository, LoginMapping loginMapping) {
        this.loginRepository = loginRepository;
        this.loginMapping = loginMapping;
    }

    @Transactional
    public ResponseEntity<?> register(LoginDto dto) {
        Login user = loginRepository.findByEmail(dto.getEmail());
        if(user == null) {
            Login user1 = loginMapping.MapLoginDtoToLogin(dto);
            loginRepository.save(user1);
            LoginResponses response = new LoginResponses("Register successful", true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        else {
            LoginResponses response = new LoginResponses("User already exists", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @Transactional
    public ResponseEntity<?> login(LoginDto dto) {
        Login user = loginRepository.findByEmail(dto.getEmail());
        if(user == null) {
            LoginResponses response = new LoginResponses("User not found.", false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        else {
            if(user.getPassword().equals(dto.getPassword())) {
                LoginResponses response = new LoginResponses("Login successful", true);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
            else {
                LoginResponses response = new LoginResponses("Invalid Password", false);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

        }
    }

    public List<LoginResponseDto> getAllUser() {
        List<Login> users = loginRepository.findAll();
        return users.stream()
                .map(login -> loginMapping.MapLoginToLoginResponseDto(login, "verified"))
                .toList();
    }
}
