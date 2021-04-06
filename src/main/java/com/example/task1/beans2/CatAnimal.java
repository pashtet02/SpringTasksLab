package com.example.task1.beans2;

import org.springframework.stereotype.Component;

@Component
public class CatAnimal {
private String breed;

    @Override
    public String toString() {
        return "CatAnimal{" +
                "price=" + breed +
                '}';
    }

}
