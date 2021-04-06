package com.example.task1.beans2;

import org.springframework.stereotype.Component;

@Component
public class NarcissusFlower {
private double price;

    @Override
    public String toString() {
        return "RoseFlower{" +
                "price=" + price +
                '}';
    }

}
