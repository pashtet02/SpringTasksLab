package com.example.library.repository.impl;

import com.example.library.exception.UserNotFoundException;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> list = new ArrayList<>();

    @Override
    public List<User> getAllUsers(){
        return list;
    }

    @Override
    public User getUser(String username) {
        return list.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst().orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(String username, User user) {
        boolean isDeleted = list.removeIf(u -> user.getUsername().equals(username));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new UserNotFoundException("User does not exists");
        }
        return user;
    }

    @Override
    public void deleteUser(String username) {
        list.removeIf(user -> user.getUsername().equals(username));
    }
}
