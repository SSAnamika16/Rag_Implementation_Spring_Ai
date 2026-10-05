package com.spring.ai.firstproject.first_project.services;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTransformerImpl implements DataTransformer {

    @Override
    public List<Document> transform(List<Document> documents) {

        // Clean malformed Unicode characters before tokenization
        List<Document> cleanedDocuments = documents.stream()
                .map(document -> new Document(
                        sanitizeText(document.getText()),
                        document.getMetadata()
                ))
                .toList();

        var splitter = TokenTextSplitter.builder()
                .withChunkSize(300)
                .withMinChunkSizeChars(400)
                .withMinChunkLengthToEmbed(10)
                .withMaxNumChunks(5000)
                .withKeepSeparator(true)
                .build();

        return splitter.transform(cleanedDocuments);
    }

    private String sanitizeText(String text) {

        if (text == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            // Valid UTF-16 surrogate pair
            if (Character.isHighSurrogate(current)) {

                if (i + 1 < text.length()
                        && Character.isLowSurrogate(text.charAt(i + 1))) {

                    result.append(current);
                    result.append(text.charAt(++i));

                } else {
                    // Invalid/unpaired high surrogate
                    result.append(' ');
                }

            } else if (Character.isLowSurrogate(current)) {

                // Invalid/unpaired low surrogate
                result.append(' ');

            } else {

                result.append(current);
            }
        }

        return result.toString();
    }
}








//package com.spring.ai.firstproject.first_project.services;
//
//
//import org.springframework.ai.document.Document;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DataTransformerImpl implements DataTransformer{
//
//
//    @Override
//    public List<Document> transform(List<Document> documents) {
//
//        var splitter = TokenTextSplitter.builder()
//                .withChunkSize(300)
//                .withMinChunkSizeChars(400)
//                .withMinChunkLengthToEmbed(10)
//                .withMaxNumChunks(5000)
//                .withKeepSeparator(true)
//                .build();
//
//        return splitter.transform(documents);
//
//    }
//}
