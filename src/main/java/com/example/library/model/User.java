package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String username;
    private String mail;
    private String password;
    private String role;
    private double fine;
    private String userLocale;
    private String firstName;
    private String lastName;
    private boolean isBanned;
}
