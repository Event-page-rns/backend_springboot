package com.example.eventus.Services;


import com.example.eventus.Dtos.ChatDto;
import com.example.eventus.Entities.Chat;
import com.example.eventus.Mappings.ChatMapping;
import com.example.eventus.Repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    public final ChatMapping chatMapping;
    public final ChatRepository chatRepository;

    public ChatService(ChatMapping chatMapping,ChatRepository chatRepository) {
        this.chatMapping = chatMapping;
        this.chatRepository = chatRepository;
    }

    public void addMessage(ChatDto chatDto) {
        try{
            Chat chat = chatMapping.MapFromChatDtoToChat(chatDto);
            chatRepository.save(chat);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<ChatDto> getAllMessages(){
        List<Chat> chat = chatRepository.findAll();
        return chat
                .stream()
                .map(chatMapping::MapFromChatToChatDto)
                .toList();
    }

}
