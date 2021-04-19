package com.example.library.controller;

import com.example.library.api.BookApi;
import com.example.library.controller.assembler.BookAssembler;
import com.example.library.controller.model.BookModel;
import com.example.library.dto.BookDto;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/books")
@Slf4j
public class BookController implements BookApi {
    private final BookService bookService;
    private final BookAssembler bookAssembler;

    /*@Override
    public List<BookModel> getAllBooks(@PathVariable String sortParam, @PathVariable String pageNumber){
       return bookService.getAllBooks().stream()
               .map(bookAssembler::toModel)
               .collect(Collectors.toList());
    }*/
    @Override
    public List<BookModel> getAllBooks(){
       return bookService.getAllBooks().stream()
               .map(bookAssembler::toModel)
               .collect(Collectors.toList());
    }

    @Override
    public BookModel getBook(String title) {
        BookDto bookDto = bookService.getBook(title);
        log.info("Get book by title: {}", title);
        return bookAssembler.toModel(bookDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public BookModel createBook(BookDto bookDto) {
        BookDto book = bookService.createBook(bookDto);
        log.info("Create book: {}", bookDto);
        return bookAssembler.toModel(book);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public BookModel updateBook(String title, BookDto bookDto) {
        log.info("Update book by title: {} book: {}", title, bookDto);
        BookDto book = bookService.updateBook(title, bookDto);
        return bookAssembler.toModel(book);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteBook(String title) {
        log.info("Delete book by title: {}", title);
        bookService.deleteBook(title);
        return ResponseEntity.noContent().build();
    }
}
