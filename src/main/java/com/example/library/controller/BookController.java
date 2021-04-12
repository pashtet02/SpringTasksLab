package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook(@PathVariable String title){
        log.info("Get book by title: {}", title);
        return bookService.getBook(title);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto bookDto){
        log.info("Create book: {}", bookDto);
        return bookService.createBook(bookDto);
    }

    @PutMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable String title,@RequestBody BookDto bookDto){
        log.info("Update book by title: {} book: {}", title, bookDto);
        return bookService.updateBook(title, bookDto);
    }

    @DeleteMapping(value = "/{title}")
    public ResponseEntity<Void> deleteBook(@PathVariable String title){
        log.info("Delete book by title: {}", title);
        bookService.deleteBook(title);
        return ResponseEntity.noContent().build();
    }
}
