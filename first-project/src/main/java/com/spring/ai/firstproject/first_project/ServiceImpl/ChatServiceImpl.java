package com.spring.ai.firstproject.first_project.ServiceImpl;

import com.spring.ai.firstproject.first_project.entity.Tut;
import com.spring.ai.firstproject.first_project.services.ChatService;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;

    public ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String chat(String query) {
        Prompt prompt1 = new Prompt(query);

//        String queryStr = "As an expert in coding and programming. Always write program in java ." + query;
//

        String queryStr = "As an expert in coding and programming. Always write program in java . Now reply for this question : {query}";


        var tutorials = chatClient
                .prompt()
                .user(u -> u.text(queryStr).param("query", query))
                .call()
                .content();

        return tutorials;


    }


    public String ChatTemplate() {

        //1st step
//        PromptTemplate strTemplate = PromptTemplate.builder().template("What is {techName} ? tell me also about {techExample}").build();
//
//        //2nd render the template
//
//        String renderedMessage = strTemplate.render(Map.of(
//                "techName", "Spring",
//                "techExample", "Spring exception"
//        ));
//
//        Prompt prompt = new Prompt(renderedMessage);
//
//       return this.chatClient.prompt(prompt).call().content();


        //2. for specific role template
//        var systemPromptTemplate = SystemPromptTemplate.builder()
//                .template("You are helpful coding assistent. You are an expert in coding.")
//                .build();
//
//        var systemMessage=systemPromptTemplate.createMessage();
//
//        var userPromptTemplate = PromptTemplate.builder().template("What is {techName}? tell me about {techExample}").build();
//
//        var userMessage= userPromptTemplate.createMessage(Map.of(
//                "techName", "Spring",
//                "techExample", "spring exception"
//        ));
//
//        Prompt prompt = new Prompt(systemMessage, userMessage);
//
//        return this.chatClient.prompt(prompt).call().content();

        //3rd by using chatClient



        return this.chatClient
                .prompt()
//                .system(system -> system.text("you are a helpful coding assitent. you are an expert in coding"))
//                .user(user -> user.text("what is {techName} ? tell me aabout {techExample}")
//                        .param("techName", "spring")
//                        .param("techExample", "spring controller example"))

                .system(system ->
                        system.text(this.systemMessage))
                .user(user ->
                        user.text(this.userMessage).param("concept", "Spring Framework validation"))
                .call()
                .content();

    }


}