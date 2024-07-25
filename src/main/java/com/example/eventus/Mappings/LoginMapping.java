package com.example.eventus.Mappings;

import com.example.eventus.Dtos.LoginDto;
import com.example.eventus.Dtos.LoginResponseDto;
import com.example.eventus.Entities.Login;
import org.springframework.stereotype.Component;

@Component
public class LoginMapping {


    public Login MapLoginDtoToLogin(LoginDto dto) {
        Login user = new Login();
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail()); // Assuming LoginDto has a getEmail() method
        return user;
    }

    public LoginResponseDto MapLoginToLoginResponseDto(Login user, String message) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setEmail(user.getEmail());
        loginResponseDto.setMessage(user.getPassword());
        return loginResponseDto;
    }
}
