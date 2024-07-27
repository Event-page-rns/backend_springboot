package com.example.eventus.Mappings;

import com.example.eventus.Dtos.ChatDto;
import com.example.eventus.Entities.Chat;
import org.springframework.stereotype.Component;


@Component
public class ChatMapping {


    public Chat MapFromChatDtoToChat(ChatDto chatDto){
        Chat chat = new Chat();
        chat.setMessage(chatDto.getMessage());
        chat.setEmail(chatDto.getEmail());
        chat.setTime(chat.getTime());
        chat.setDate(chat.getDate());
        return chat;
    }

    public ChatDto MapFromChatToChatDto(Chat chat){
        ChatDto chatDto = new ChatDto();
        chatDto.setMessage(chat.getMessage());
        chatDto.setEmail(chat.getEmail());
        chatDto.setDate(chat.getDate());
        chatDto.setTime(chat.getTime());
        return  chatDto;
    }




}
