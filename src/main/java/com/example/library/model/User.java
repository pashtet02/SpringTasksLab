package com.example.library.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
