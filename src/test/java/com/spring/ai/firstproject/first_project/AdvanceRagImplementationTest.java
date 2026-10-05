package com.spring.ai.firstproject.first_project;

import com.spring.ai.firstproject.first_project.services.DataLoader;
import com.spring.ai.firstproject.first_project.services.DataTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdvanceRagImplementationTest {

//	@Test
//	void contextLoads() {
//	}

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

//    @Autowired
//    private ChatService chatService;
//
//    @Test
//    void saveDataToVectorDatabase() {
//
//        System.out.println("saving data into database");
//        this.chatService.saveData(Helper.getData());
//        System.out.println("Data is saved successfully");
//
//    }

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private DataTransformer dataTransformer;

    @Autowired
    private VectorStore vectorStore;

    @Test
    void testDataLoader() {

      var documents =  dataLoader.loadDocumentsFromJson();
        System.out.println(documents.size());

        documents.forEach(item -> {
            System.out.println(item);
        });

    }


    @Test
    void testPdfDataLoader() {
        List<Document> documents = this.dataLoader.loadDocumentsFromPdf();
        System.out.println(documents.size());
        documents.forEach(item -> {
            System.out.println(item);
            System.out.println("__________-");
        });

        System.out.println("Read__now going to transform");

        var transformedDocument = this.dataTransformer.transform(documents);
        System.out.println(transformedDocument);

        // going to save the data into database

        this.vectorStore.add(transformedDocument);
        System.out.println("Done");

    }





}
