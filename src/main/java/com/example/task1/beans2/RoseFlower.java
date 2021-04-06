package com.example.task1.beans2;

import org.springframework.stereotype.Component;

@Component
public class RoseFlower {
private double price;

    @Override
    public String toString() {
        return "RoseFlower{" +
                "price=" + price +
                '}';
    }

}
