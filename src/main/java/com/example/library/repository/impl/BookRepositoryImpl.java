package com.example.library.repository.impl;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {
    List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> getAllBooks(){
        return bookList;
    }

    @Override
    public Book getBook(String title){
       return bookList.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book createBook(Book book) {
        bookList.add(book);
        return book;
    }

    @Override
    public Book updateBook(String title, Book book) {
        boolean isDeleted = bookList.removeIf(b -> book.getTitle().equals(title));
        if (isDeleted) {
            bookList.add(book);
        } else {
            throw new BookNotFoundException("Book does not exists");
        }
        return book;
    }

    @Override
    public void deleteBook(String title) {
        bookList.removeIf(book -> book.getTitle().equals(title));
    }
}
