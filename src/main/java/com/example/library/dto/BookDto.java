package com.example.library.dto;

import com.example.library.validation.UniqueUsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
    private long id;

    @NotNull(message = "${bootTitle.notempty}")
    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotNull(message = "${bootTitle.notempty}")
    @NotBlank(message = "title cannot be empty")
    private String author;

    @Positive
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
