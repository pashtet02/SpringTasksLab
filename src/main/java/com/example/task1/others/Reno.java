package com.example.task1.others;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Reno implements Car {
    public String getCar() {
        return "Renault Logan";
    }  }