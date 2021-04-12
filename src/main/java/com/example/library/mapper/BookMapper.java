package com.example.library.mapper;

import com.example.library.dto.BookDto;
import com.example.library.model.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookDtoToBook(BookDto bookDto);

    @InheritInverseConfiguration
    BookDto bookToBookDto(Book book);
}
