package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
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

    public BookDto(long id, String title, String author, long isbn, String publisher, Date publishingDate, int numberOfCopies, String language, String image, String description) {
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
    public BookDto(){
        //hello
    }
}
