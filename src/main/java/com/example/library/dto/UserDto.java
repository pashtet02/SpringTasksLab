package com.example.library.dto;

import com.example.library.validation.FieldsValueMatch;
import com.example.library.validation.UniqueUsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Passwords do not match!"
        )
})
public class UserDto {

    @PositiveOrZero
    private long id;

    @NotNull(message = "${username.notempty}")
    @NotBlank(message = "username cannot be empty")
    @UniqueUsernameConstraint
    private String username;

    @NotEmpty(message = "${email.notempty}")
    @NotNull
    @Email(message = "${email.notvalid}")
    private String mail;

    private String password;
    private String repeatPassword;

    @Pattern(regexp = "(ADMIN|USER)", message = "${role.notvalid}")
    private String role;

    @PositiveOrZero(message = "${fine.notvalid}")
    private double fine;

    private String userLocale;
    private String firstName;
    private String lastName;
    private boolean isBanned;

    public UserDto(long id, String username, String mail, String password, String repeatPassword, String role, double fine, String userLocale, String firstName, String lastName, boolean isBanned) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
        this.fine = fine;
        this.userLocale = userLocale;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBanned = isBanned;
    }

    public UserDto() {
        //hello
    }
}
