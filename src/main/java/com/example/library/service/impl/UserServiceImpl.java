package com.example.library.service.impl;

import com.example.library.dto.UserDto;
import com.example.library.mapper.UserMapper;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    //method to get list of all users in info endpoint
    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.getAllUsers()) {
            userDtoList.add(UserMapper.INSTANCE.toUserDto(user));
        }
        log.info("getAllUsers, numberOf users: {}", userDtoList.size());
        return userDtoList;
    }

    @Override
    public UserDto getUser(String username) {
        User user = userRepository.getUser(username);
        log.debug("getUser() by username {}", username);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user = userRepository.createUser(user);
        log.debug("createUser() from {}", userDto);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto updateUser(String username, UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user = userRepository.updateUser(username, user);
        log.debug("updateUser() by username {}, from dto: {}", username, userDto);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public void deleteUser(String username) {
        log.debug("deleteUser() by username {}", username);
        userRepository.deleteUser(username);
    }

}
