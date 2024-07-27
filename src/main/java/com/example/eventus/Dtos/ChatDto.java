package com.example.eventus.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {

    private String message;

    private String email;

    private String Date;

    private String time;
}
