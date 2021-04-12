package com.example.library.validation;

import com.example.library.dto.UserDto;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsernameConstraint, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueUsernameConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        List<UserDto> allUsers = userService.getAllUsers();
        return allUsers.stream().noneMatch(userDto -> userDto.getUsername().equals(username));
    }
}
