package com.spring.ai.firstproject.first_project.controllers;


import com.spring.ai.firstproject.first_project.entity.Tut;
import com.spring.ai.firstproject.first_project.services.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ChatController {


    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value ="q", required = true) String q) {

        return ResponseEntity.ok(chatService.chatTemplate(q));

    }



}

















