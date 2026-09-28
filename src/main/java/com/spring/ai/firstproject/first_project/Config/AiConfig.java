package com.spring.ai.firstproject.first_project.Config;




import com.spring.ai.firstproject.first_project.advisors.TokenPinAdvisor;
import org.antlr.runtime.Token;
import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.ollama.OllamaChatModel;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {


    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {

        return builder
                .defaultAdvisors(new TokenPinAdvisor(), new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("games")))
                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
                .defaultOptions(
                        OllamaChatOptions.builder()
                                .model("codellama:latest")
                                .temperature(0.7)
                                .maxTokens(100)
                )
                .build();
    }



//    @Bean(name = "openAiChatClient")
//    public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
//        return ChatClient.builder(chatModel).build();
//    }
//
//    @Bean(name = "ollamaChatClient")
//    public ChatClient ollamaChatModel(OllamaChatModel chatModel) {
//        return ChatClient.builder(chatModel).build();
//    }

}
