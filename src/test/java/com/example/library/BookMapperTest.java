package com.example.library;

import com.example.library.dto.BookDto;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookMapperTest {
        @Test
        public void bookToBookDtoTest() {
            Book book = new Book();
            book.setTitle("SourceName");
            book.setDescription("SourceDescription");
            BookDto bookDto = BookMapper.INSTANCE.bookToBookDto(book);

            assertEquals(book.getTitle(), bookDto.getTitle());
            assertEquals(book.getDescription(),
                    bookDto.getDescription());
        }
        @Test
        public void bookDtoToBookTest() {
            BookDto bookDto = new BookDto();
            bookDto.setTitle("DestinationName");
            bookDto.setDescription("DestinationDescription");
            Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);
            assertEquals(book.getTitle(), bookDto.getTitle());
            assertEquals(book.getDescription(),
                    bookDto.getDescription());
        }
    }

