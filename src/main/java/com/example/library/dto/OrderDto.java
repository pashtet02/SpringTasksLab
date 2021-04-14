package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long id;
    private long userId;
    private long bookId;
    private String username;
    private  String userMail;
    private String librarianComment;
    private int booksNumber;
    private String userFirstName;
    private String userSecondName;
    private double userFine;
    private String bookTitle;
    private String bookAuthor;
    private String userComment;
    private LocalDateTime startDate;
    private Date returnDate;
    private String status;
}
