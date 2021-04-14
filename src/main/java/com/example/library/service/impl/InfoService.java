package com.example.library.service.impl;

import com.example.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class InfoService implements InfoContributor {
    private final UserService userService;

    @Autowired
    public InfoService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> totalUsersNumber = new HashMap<>();
        int numOfUsers = userService.getAllUsers().size();
        totalUsersNumber.put("Number of users: ", numOfUsers);
        builder.withDetail("Users metric", totalUsersNumber);
        log.info("Someone user /info endpoint, time: {}, number of users now: {}" , LocalDateTime.now(), numOfUsers);
    }
}
