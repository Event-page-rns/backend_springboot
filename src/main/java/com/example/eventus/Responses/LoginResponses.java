package com.example.eventus.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponses {
    private String message;
    private String role;
    private Boolean isSuccess;
}
