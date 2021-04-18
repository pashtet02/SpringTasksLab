package com.example.library.controller;

import com.example.library.api.UserApi;
import com.example.library.controller.assembler.UserAssembler;
import com.example.library.controller.model.UserModel;
import com.example.library.dto.UserDto;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@Slf4j
public class UserController implements UserApi {
    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String username) {
        log.info("Get user by username: {}", username);
        UserDto userDto = userService.getUser(username);
        return userAssembler.toModel(userDto);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("Create user: {}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String username, UserDto userDto) {
        log.info("Update user by username: {} user: {}", username, userDto);
        UserDto user = userService.updateUser(username, userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        log.info("Delete user by username: {}", username);
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
