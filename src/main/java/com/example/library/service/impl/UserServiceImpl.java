package com.example.library.service.impl;

import com.example.library.dto.UserDto;
import com.example.library.exception.ServiceException;
import com.example.library.exception.UserNotFoundException;
import com.example.library.mapper.UserMapper;
import com.example.library.model.User;
import com.example.library.registration.token.ConfirmationToken;
import com.example.library.registration.token.ConfirmationTokenService;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final String USER_NOT_FOUND_MESSAGE = "User with username: %s now found";
    private final ConfirmationTokenService tokenService;

    @Override
    public List<UserDto> getAllUsers(Pageable pageRequest) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.findAll(pageRequest)) {
            userDtoList.add(UserMapper.INSTANCE.toUserDto(user));
        }
        log.info("getAllUsers, numberOf users: {}", userDtoList.size());
        return userDtoList;
    }

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
        String encryptedPass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        user = userRepository.save(user);
        log.debug("createUser() from {}", userDto);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public UserDto updateUser(String username, UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        if (!userRepository.existsByUsername(username)) {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, username)));
    }

    @Override
    public String signUpUser(User user) {
        boolean isExists = userRepository.existsByUsername(user.getUsername());
        if (isExists) {
            throw new ServiceException("Such user already exists!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        String tokenUUID = UUID.randomUUID().toString();

        ConfirmationToken token = new ConfirmationToken(
                tokenUUID,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user);
        tokenService.saveConfirmationToken(token);

        //TODO send email
        return token.getToken();
    }

    @Override
    public int enableUser(String username) {
        return userRepository.enableUser(username);
    }
}
