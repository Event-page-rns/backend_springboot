package com.example.eventus.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventusResponses {

    private String responseMessage;

    private Boolean isSuccess;

}
