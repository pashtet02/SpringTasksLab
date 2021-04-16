package com.example.library.service;

import com.example.library.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    BookDto getBook(String title);

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(String title, BookDto bookDto);

    void deleteBook(String title);
}
