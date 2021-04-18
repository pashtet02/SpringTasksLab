package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private double fine;
    private String userLocale;
    private String firstName;
    private String lastName;
    private boolean isBanned;




}
