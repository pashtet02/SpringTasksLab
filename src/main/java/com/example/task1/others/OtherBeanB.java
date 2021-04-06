package com.example.task1.others;

import org.springframework.stereotype.Component;

@Component
public class OtherBeanB {
    private String otherName;

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public OtherBeanB() {
    }

    public OtherBeanB(String otherName) {
        this.otherName = otherName;
    }
}