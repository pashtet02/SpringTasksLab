package com.example.library.service.impl;

import com.example.library.dto.BookDto;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto getBook(String title) {
        Book book = bookRepository.getBook(title);
        log.debug("getBook() by title {}", title);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.INSTANCE.toBook(bookDto);
        book = bookRepository.createBook(book);
        log.debug("createBook() from {}", bookDto);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public BookDto updateBook(String title, BookDto bookDto) {
        Book book = BookMapper.INSTANCE.toBook(bookDto);
        book = bookRepository.updateBook(title, book);
        log.debug("updateBook() by title {}, from dto: {}", title, bookDto);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public void deleteBook(String title) {
        log.debug("deleteBook() by title {}", title);
        bookRepository.deleteBook(title);
    }
}
