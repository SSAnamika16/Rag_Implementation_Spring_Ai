package com.spring.ai.firstproject.first_project.services;

import com.spring.ai.firstproject.first_project.entity.Tut;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {



    String getResponse(String userQuery);

    void saveData(List<String> list);

}
