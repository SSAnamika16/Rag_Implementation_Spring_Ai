package com.spring.ai.firstproject.first_project.ServiceImpl;


import com.spring.ai.firstproject.first_project.entity.Tut;
import com.spring.ai.firstproject.first_project.services.ChatService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import org.springframework.ai.chat.memory.ChatMemory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ChatClient chatClient;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    private VectorStore vectorStore;


    public ChatServiceImpl(ChatClient chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }




    @Override
    public String chatTemplate(String query, String userId) {

        // load data from vector database

//        SearchRequest  searchRequest = SearchRequest.builder()
//                .topK(5)
//                .similarityThreshold(0.6)
//                .query(query)
//                .build();
//
//        List<Document> documents = this.vectorStore.similaritySearch(searchRequest);
//        List<String> documentList = documents.stream().map(Document::getText).toList();
//
//        String contextData = String.join(", ", documentList);
//        logger.info("Context Data: {}", contextData);

        // similar result user query
        // pass in context



        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, userId))
//                .system(system ->
//                        system.text(this.systemMessage).param("documents", contextData))

//                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .advisors(
                        QuestionAnswerAdvisor
                                .builder(vectorStore)
                                .searchRequest(SearchRequest.builder()
                                        .topK(3)
                                        .similarityThreshold(0.5)
                                        .build()).build()
                )
                .user(user ->
                        user.text(this.userMessage).param("query", query))

                .call()
                .content();


    }

    @Override
    public Flux<String> streamChat(String query) {


        return this.chatClient
                .prompt()
//                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, userId))
                .system(system -> system.text(this.systemMessage))
                .user(user -> user.text(this.userMessage).param("concept", query))
                .stream()
                .content();

    }

    @Override
    public void saveData(List<String> list) {

       // List<Document> documentList = list.stream().map(item -> new Document(item)).collect(Collectors.toList());

        List<Document> documentList = list.stream().map(Document::new).toList();
        this.vectorStore.add(documentList);

    }



}