package com.example.library.repository;

import com.example.library.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUser(String username);

    User createUser(User user);

    User updateUser(String username, User user);

    void deleteUser(String username);
}
