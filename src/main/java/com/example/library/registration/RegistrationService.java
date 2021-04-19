package com.example.library.registration;

import com.example.library.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface RegistrationService {
    String register(UserDto userDto);

    @Transactional
    String confirmToken(String token);
}
