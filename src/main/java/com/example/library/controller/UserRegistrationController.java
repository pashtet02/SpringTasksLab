package com.example.library.controller;

import com.example.library.dto.UserDto;
import com.example.library.registration.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
@Slf4j
public class UserRegistrationController {
    private final RegistrationService registrationService;

    @PostMapping()
    public String register(@RequestBody UserDto userDto){
        log.info("Register request user: {}", userDto);
        return registrationService.register(userDto);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
