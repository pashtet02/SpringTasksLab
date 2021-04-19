package com.example.library.dto;

import com.example.library.model.enums.Role;
import com.example.library.validation.FieldsValueMatch;
import com.example.library.validation.UniqueEmailConstraint;
import com.example.library.validation.UniqueUsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "{password.mustmatch}"
        )
})
public class UserDto {

    private long id;

    @NotNull(message = "{username.notempty}")
    @NotBlank(message = "username cannot be empty")
    @UniqueUsernameConstraint
    private String username;

    @NotEmpty(message = "{email.notempty}")
    @NotNull
    @Email(message = "{email.notvalid}")
    @UniqueEmailConstraint
    private String email;

    private String password;
    private String repeatPassword;

    private Set<Role> roles;

    @PositiveOrZero(message = "{fine.notvalid}")
    private double fine;

    private String firstName;
    private String lastName;
    private boolean active;

}
