package com.example.library.validation;

import com.example.library.dto.UserDto;
import com.example.library.service.UserService;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailConstraint, String> {

    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueEmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        List<UserDto> allUsers = userService.getAllUsers();
        return allUsers.stream().noneMatch(userDto -> userDto.getUsername().equals(username));
    }
}