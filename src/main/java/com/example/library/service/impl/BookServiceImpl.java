package com.example.library.service.impl;

import com.example.library.dto.BookDto;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto getBook(String title) {
        Book book = bookRepository.getBook(title);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.INSTANCE.toBook(bookDto);
        book = bookRepository.createBook(book);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public BookDto updateBook(String title, BookDto bookDto) {
        Book book = BookMapper.INSTANCE.toBook(bookDto);
        book = bookRepository.updateBook(title, book);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public void deleteBook(String title) {
        bookRepository.deleteBook(title);
    }
}
