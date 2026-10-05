package com.spring.ai.firstproject.first_project.services;

import org.springframework.ai.document.Document;

import java.util.List;

public interface DataLoader {

    List<Document> loadDocumentsFromJson();

    List<Document> loadDocumentsFromPdf();


}
