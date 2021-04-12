package com.example.library.service.impl;

import com.example.library.dto.UserDto;
import com.example.library.mapper.UserMapper;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    //method to get list of all users in info endpoint
    @Override
    public List<UserDto> getAllUsers(){
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user: userRepository.getAllUsers()) {
            userDtoList.add(UserMapper.INSTANCE.toUserDto(user));
        }
        return userDtoList;
    }

    @Override
    public UserDto getUser(String username) {
        User user = userRepository.getUser(username);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user = userRepository.createUser(user);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto updateUser(String username, UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user = userRepository.updateUser(username, user);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }
}
