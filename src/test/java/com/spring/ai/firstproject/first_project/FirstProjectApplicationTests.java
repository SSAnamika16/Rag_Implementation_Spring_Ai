package com.spring.ai.firstproject.first_project;

import com.spring.ai.firstproject.first_project.helper.Helper;
import com.spring.ai.firstproject.first_project.services.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstProjectApplicationTests {

	@Test
	void contextLoads() {
	}

//    @Autowired
//    private ChatService chatService;


//    @Test
//    void testTemplateRender() {
//        System.out.println("Template Rendered");
//
//        var output = this.chatService.ChatTemplate();
//        System.out.println(output);
//
//    }

    @Autowired
    private ChatService chatService;

    @Test
    void saveDataToVectorDatabase() {

        System.out.println("saving data into database");
        this.chatService.saveData(Helper.getData());
        System.out.println("Data is saved successfully");

    }




}
