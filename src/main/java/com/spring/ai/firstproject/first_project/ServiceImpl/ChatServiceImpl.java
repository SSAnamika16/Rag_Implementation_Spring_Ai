package com.spring.ai.firstproject.first_project.ServiceImpl;

import com.spring.ai.firstproject.first_project.entity.Tut;
import com.spring.ai.firstproject.first_project.services.ChatService;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;


    public ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }


    @Override
    public String chatTemplate(String query) {

        return this.chatClient
                .prompt()
//                .advisors(new SimpleLoggerAdvisor())
                .system(system ->
                        system.text(this.systemMessage))

                .user(user ->
                        user.text(this.userMessage).param("concept", query))

                .call()
                .content();


    }

    @Override
    public Flux<String> streamChat(String query) {


        return this.chatClient
                .prompt()
                .system(system -> system.text(this.systemMessage))
                .user(user -> user.text(this.userMessage).param("concept", query))
                .stream()
                .content();

    }




}