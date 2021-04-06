package com.example.task1.others;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Lanos implements Car {
    public String getCar() {
        return "Lanos";
    }
}