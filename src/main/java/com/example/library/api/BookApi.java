package com.example.library.api;

import com.example.library.controller.model.BookModel;
import com.example.library.dto.BookDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Book management API")
@RequestMapping("/api/v1/books")
public interface BookApi {

    @ApiOperation("Get all books")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<BookModel> getAllBooks();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Book title"),
    })
    @ApiOperation("Get book by title")
    @GetMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    BookModel getBook(@PathVariable String title);

    @ApiOperation("Create book")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    BookModel createBook(@Valid @RequestBody BookDto bookDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Book title"),
    })
    @ApiOperation("Update book by title")
    @PutMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    BookModel updateBook(@PathVariable String title, @Valid @RequestBody BookDto bookDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Book title"),
    })
    @ApiOperation("Delete book by title")
    @DeleteMapping(value = "/{title}")
    @PreAuthorize("hasAuthority('ADMIN')")
    ResponseEntity<Void> deleteBook(@PathVariable String title);
}
