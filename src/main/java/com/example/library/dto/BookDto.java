package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long id;

    @NotNull(message = "{bootTitle.notempty}")
    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotNull(message = "{bootTitle.notempty}")
    @NotBlank(message = "author cannot be empty")
    private String author;

    @Positive
    private long isbn;
    private String publisher;
    private int numberOfCopies;
    private String language;
    private String image;
    private String description;
}
