package com.example.library.service.impl;

import com.example.library.dto.BookDto;
import com.example.library.exception.BookNotFoundException;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooks(){
        List<Book> lst = (List<Book>) bookRepository.findAll();
        return lst.stream()
                .map(BookMapper.INSTANCE::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBook(String title) {
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(BookNotFoundException::new);
        log.debug("getBook() by title {}", title);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.INSTANCE.toBook(bookDto);
        book = bookRepository.save(book);
        log.debug("createBook() from {}", bookDto);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public BookDto updateBook(String title, BookDto bookDto) {
        Book book = BookMapper.INSTANCE.toBook(bookDto);
        if (!bookRepository.existsById(book.getId())){
            throw new BookNotFoundException();
        }
        book = bookRepository.save(book);
        log.debug("updateBook() by title {}, from dto: {}", title, bookDto);
        return BookMapper.INSTANCE.toBookDto(book);
    }

    @Override
    public void deleteBook(String title) {
        log.debug("deleteBook() by title {}", title);
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.delete(book);
    }
}
