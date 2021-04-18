package com.example.library.service.impl;

import com.example.library.dto.UserDto;
import com.example.library.exception.UserNotFoundException;
import com.example.library.mapper.UserMapper;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    //method to get list of all users in info endpoint
    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userDtoList.add(UserMapper.INSTANCE.toUserDto(user));
        }
        log.info("getAllUsers, numberOf users: {}", userDtoList.size());
        return userDtoList;
    }

    @Override
    public UserDto getUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
        log.debug("getUser() by username {}", username);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        user = userRepository.save(user);
        log.debug("createUser() from {}", userDto);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto updateUser(String username, UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        if (!userRepository.existsByUsername(username)){
            throw new UserNotFoundException();
        }
        user = userRepository.save(user);
        log.debug("updateUser() by username {}, from dto: {}", username, userDto);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public void deleteUser(String username) {
        log.debug("deleteUser() by username {}", username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

}
