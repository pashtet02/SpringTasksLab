package com.example.task2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("beanB")
public class BeanC extends MyBean{
    @Value("${beanC.value}")
    private int value;
    @Value("${beanC.name}")
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

    public BeanC() {
        System.out.println("BeanC constructor");
    }

    public void myInitMethod(){
        System.out.println("beanC init method");
    }

    public void myDestroyMethod(){
        System.out.println("beanC destroy method");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
