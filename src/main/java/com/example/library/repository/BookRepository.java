package com.example.library.repository;

import com.example.library.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();

    Book getBook(String title);

    Book createBook(Book book);

    Book updateBook(String title, Book book);

    void deleteBook(String title);
}
