package com.spring.ai.firstproject.first_project.services;

import com.spring.ai.firstproject.first_project.entity.Tut;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {


    String chatTemplate(String query, String userId);
//      List<Tut> chat(String query);

//    public String ChatTemplate();
    Flux<String> streamChat(String query);

    void saveData(List<String> list);

}
