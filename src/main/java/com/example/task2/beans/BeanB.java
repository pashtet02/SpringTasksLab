package com.example.task2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@DependsOn("beanD")
public class BeanB extends MyBean{
    @Value("${beanB.value}")
    private int value;
    @Value("${beanB.name}")
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

    public BeanB() {
        System.out.println("BeanB constructor");
    }

    public void myInitMethod(){
        System.out.println("beanB init method");
    }

    public void myDestroyMethod(){
        System.out.println("beanB destroy method");
    }

    public void anotherInitMethod(){
        System.out.println("anotherInitMethod() in bean B switched from MyBeanFactoryPostProcessor");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
