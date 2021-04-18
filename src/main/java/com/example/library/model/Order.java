package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

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
