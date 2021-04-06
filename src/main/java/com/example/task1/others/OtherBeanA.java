package com.example.task1.others;

import org.springframework.stereotype.Component;

@Component
public class OtherBeanA {
    private String otherName;

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public OtherBeanA(String otherName) {
        this.otherName = otherName;
    }

    public OtherBeanA() {
    }
}
