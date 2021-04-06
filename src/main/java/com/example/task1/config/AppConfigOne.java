package com.example.task1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.task1.beans1", "com.example.task1.others"})
public class AppConfigOne {
}
