package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    private String title;
    private String author;
    private long isbn;
    private String publisher;
    private int numberOfCopies;
    private String language;
    private String image;
    private String description;
}
