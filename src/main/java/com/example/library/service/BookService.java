package com.example.library.service;

import com.example.library.dto.BookDto;

public interface BookService {
    BookDto getBook(String title);

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(String title, BookDto bookDto);

    void deleteBook(String title);
}
