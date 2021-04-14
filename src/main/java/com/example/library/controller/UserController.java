package com.example.library.controller;

import com.example.library.dto.UserDto;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable String username) {
        log.info("Get user by username: {}", username);
        return userService.getUser(username);
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createBook(@Valid @RequestBody UserDto userDto) {
        log.info("Create user: {}", userDto);
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable String username, @Valid @RequestBody UserDto userDto) {
        log.info("Update user by username: {} user: {}", username, userDto);
        return userService.updateUser(username, userDto);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        log.info("Delete user by username: {}", username);
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
