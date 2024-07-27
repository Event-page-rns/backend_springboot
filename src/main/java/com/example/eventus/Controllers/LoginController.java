package com.example.eventus.Controllers;


import com.example.eventus.Dtos.LoginDto;
import com.example.eventus.Dtos.LoginResponseDto;
import com.example.eventus.Services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginDto dto) {
        return loginService.register(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        return loginService.login(dto);
    }

    @GetMapping("/getUsers")
    public List<LoginResponseDto> getAllUsers() {
        return loginService.getAllUser();
    }
}
