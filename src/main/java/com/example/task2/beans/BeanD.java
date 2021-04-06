package com.example.task2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD extends MyBean{
    @Value("${beanD.value}")
    private int value;
    @Value("${beanD.name}")
    private String name;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public BeanD() {
        System.out.println("BeanD constructor");
    }

    public void myInitMethod(){
        System.out.println("beanD init method");
    }

    public void myDestroyMethod(){
        System.out.println("beanD destroy method");
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
