package com.example.library.service;

import com.example.library.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUser(String username);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String username, UserDto userDto);

    void deleteUser(String username);
}
