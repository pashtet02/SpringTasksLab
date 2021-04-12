package com.example.library.repository;

import com.example.library.model.Book;

public interface BookRepository {
    Book getBook(String title);

    Book createBook(Book book);

    Book updateBook(String title, Book book);

    void deleteBook(String title);
}
