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

    public User(long id, String username, String mail, String password, String role, double fine, String userLocale, String firstName, String lastName, boolean isBanned) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.role = role;
        this.fine = fine;
        this.userLocale = userLocale;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBanned = isBanned;
    }
    public User(){
        //hsdfsd
    }
}
