package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAllByAuthor(String author, Pageable pageable);
    Optional<Book> findByTitle(String title);
}
