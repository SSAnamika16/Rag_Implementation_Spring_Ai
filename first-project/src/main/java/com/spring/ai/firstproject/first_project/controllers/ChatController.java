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

//    private ChatClient chatClient;

    private ChatService chatService;

//    public ChatController(ChatClient chatClient) {
//        this.chatClient = chatClient;
//    }

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {

        return ResponseEntity.ok(chatService.chat(q));
    }





//    private ChatClient openAiChatClient;
//
//    private ChatClient ollamaChatClient;



//    public ChatController(ChatClient.Builder builder) {
//        this.chatClient = builder.build();
//    }

////    creating chatClient by using chatModel
//
//    public ChatController(ChatModel chatModel) {
//        System.out.println(chatModel.getClass().getName());
//        this.chatClient = ChatClient.builder(chatModel).build();
//    }

//      public ChatController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
//          this.openAiChatClient=ChatClient.builder(openAiChatModel).build();
//          this.ollamaChatClient=ChatClient.builder(ollamaChatModel).build();
//
//      }

// public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient,@Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
//     this.openAiChatClient = openAiChatClient;
//     this.ollamaChatClient = ollamaChatClient;
// }

//
//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(
//            @RequestParam(value = "q", required = true) String q) {
//
//        var resultResponse = this.ollamaChatClient
//                .prompt(q)
//                .call()
//                .content();
//
//        return ResponseEntity.ok(resultResponse);
//    }


}

























//1. private final ChatClient chatClient;
//
//    public ChatController(ChatClient.Builder builder) {
//        this.chatClient = builder.build();
//    }
//
/// ///    creating chatClient by using chatModel
/// /
/// /    public ChatController(ChatModel chatModel) {
/// /        System.out.println(chatModel.getClass().getName());
/// /        this.chatClient = ChatClient.builder(chatModel).build();
/// /    }
//
//
//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {
//
//        var resultResponse = this.chatClient.prompt(q)
//                .call()
//                .content();
//
//        return ResponseEntity.ok(resultResponse);
//    }




////////////////2



//package com.spring.ai.firstproject.first_project.controllers;
//
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.ollama.OllamaChatModel;
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping
//public class ChatController {
//
//    //  private final ChatClient chatClient;
//
//    private ChatClient openAiChatClient;
//
//    private ChatClient ollamaChatClient;



//    public ChatController(ChatClient.Builder builder) {
//        this.chatClient = builder.build();
//    }

    ////    creating chatClient by using chatModel
//
//    public ChatController(ChatModel chatModel) {
//        System.out.println(chatModel.getClass().getName());
//        this.chatClient = ChatClient.builder(chatModel).build();
//    }

//      public ChatController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
//          this.openAiChatClient=ChatClient.builder(openAiChatModel).build();
//          this.ollamaChatClient=ChatClient.builder(ollamaChatModel).build();
//
//      }

//    public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient,@Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
//        this.openAiChatClient = openAiChatClient;
//        this.ollamaChatClient = ollamaChatClient;
//    }
//
//
//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(
//            @RequestParam(value = "q", required = true) String q) {
//
//        var resultResponse = this.ollamaChatClient
//                .prompt(q)
//                .call()
//                .content();
//
//        return ResponseEntity.ok(resultResponse);
//    }


//}



//1. private final ChatClient chatClient;
//
//    public ChatController(ChatClient.Builder builder) {
//        this.chatClient = builder.build();
//    }
//
/// ///    creating chatClient by using chatModel
/// /
/// /    public ChatController(ChatModel chatModel) {
/// /        System.out.println(chatModel.getClass().getName());
/// /        this.chatClient = ChatClient.builder(chatModel).build();
/// /    }
//
//
//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {
//
//        var resultResponse = this.chatClient.prompt(q)
//                .call()
//                .content();
//
//        return ResponseEntity.ok(resultResponse);
//    }