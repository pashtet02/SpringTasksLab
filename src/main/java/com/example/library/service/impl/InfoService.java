package com.example.library.service.impl;

import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoService implements InfoContributor {
    private final UserService userService;

    @Autowired
    public InfoService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> totalUsersNumber = new HashMap<>();
        totalUsersNumber.put("Number of users: ", userService.getAllUsers().size());
        builder.withDetail("Users metric", totalUsersNumber);
    }
}
