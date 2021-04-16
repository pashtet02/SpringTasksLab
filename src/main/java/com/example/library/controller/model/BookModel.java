package com.example.library.controller.model;

import com.example.library.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BookModel extends RepresentationModel<BookModel> {

    @JsonUnwrapped
    private BookDto bookDto;

}