package com.example.library.controller.assembler;

import com.example.library.controller.BookController;
import com.example.library.controller.model.BookModel;
import com.example.library.dto.BookDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookAssembler extends RepresentationModelAssemblerSupport<BookDto, BookModel> {

    public BookAssembler() {
        super(BookController.class, BookModel.class);
    }

    @Override
    public BookModel toModel(BookDto entity) {
        BookModel bookModel = new BookModel(entity);

        Link get = linkTo(methodOn(BookController.class).getBook(entity.getTitle())).withRel("get");
        Link create = linkTo(methodOn(BookController.class).createBook(entity)).withRel("create");
        Link update = linkTo(methodOn(BookController.class).updateBook(entity.getTitle(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(BookController.class).deleteBook(entity.getTitle()))
                .withRel("delete");

        bookModel.add(get, create, update, delete);

        return bookModel;
    }
}