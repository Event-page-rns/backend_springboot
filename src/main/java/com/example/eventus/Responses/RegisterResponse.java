package com.example.eventus.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponse {

    private String message;
    private Boolean isSuccess;
}
