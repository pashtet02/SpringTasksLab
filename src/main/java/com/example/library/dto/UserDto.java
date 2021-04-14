package com.example.library.dto;

import com.example.library.validation.FieldsValueMatch;
import com.example.library.validation.UniqueUsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

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

    @PositiveOrZero
    private long id;

    @NotNull(message = "{username.notempty}")
    @NotBlank(message = "username cannot be empty")
    @UniqueUsernameConstraint
    private String username;

    @NotEmpty(message = "{email.notempty}")
    @NotNull
    @Email(message = "{email.notvalid}")
    private String mail;

    private String password;
    private String repeatPassword;

    @Pattern(regexp = "(ADMIN|USER)", message = "{role.notvalid}")
    private String role;

    @PositiveOrZero(message = "{fine.notvalid}")
    private double fine;

    private String userLocale;
    private String firstName;
    private String lastName;
    private boolean isBanned;

}
