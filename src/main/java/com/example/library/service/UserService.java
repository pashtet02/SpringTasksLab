package com.example.library.service;

import com.example.library.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsers(Pageable pageRequest);

    UserDto getUser(String username);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String username, UserDto userDto);

    void deleteUser(String username);
}
