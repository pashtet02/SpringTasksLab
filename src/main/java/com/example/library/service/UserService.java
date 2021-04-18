package com.example.library.service;

import com.example.library.dto.UserDto;
import com.example.library.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUser(String username);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String username, UserDto userDto);

    void deleteUser(String username);
}
