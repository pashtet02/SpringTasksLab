package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
    private Date publishingDate;
    private int numberOfCopies;
    private String language;
    private String image;
    private String description;
}
