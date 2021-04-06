package com.example.task1.others;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(25)
public class Toyota implements Car {
    public String getCar() {
        return "Toyota Corolla";
    }  }