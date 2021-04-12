package com.example.library.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
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

    public Book(long id, String title, String author, long isbn, String publisher, Date publishingDate, int numberOfCopies, String language, String image, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
        this.numberOfCopies = numberOfCopies;
        this.language = language;
        this.image = image;
        this.description = description;
    }

    public Book(){
        //hello
    }
}
