package com.example.library.api;

import com.example.library.controller.model.UserModel;
import com.example.library.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User management API")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", required = true, value = "User username"),
    })
    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{username}")
    UserModel getUser(@PathVariable String username);

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", required = true, value = "User username"),
    })
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{username}")
    UserModel updateUser(@PathVariable String username, @RequestBody UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", required = true, value = "User username"),
    })
    @ApiOperation("Delete user")
    @DeleteMapping(value = "/{username}")
    ResponseEntity<Void> deleteUser(@PathVariable String username);

}