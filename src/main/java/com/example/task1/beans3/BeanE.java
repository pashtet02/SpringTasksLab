package com.example.task1.beans3;

import org.springframework.stereotype.Component;

@Component
public class BeanE {
    private String name;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                '}';
    }

}
