package com.example.eventus.Controllers;


import com.example.eventus.Dtos.ChatDto;
import com.example.eventus.Entities.Chat;
import com.example.eventus.Services.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ChatController {


    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/sendMessage")
    public void addMessage(@RequestBody ChatDto chatDto){
        chatService.addMessage(chatDto);
    }

    @PostMapping("/getAllMessages")
    public List<ChatDto> getAllMessages(){
        return chatService.getAllMessages();
    }


}
