package com.example.task2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE extends MyBean{

    @PostConstruct
    public void postConstruct(){
        System.out.println("Inside @PostConstruct in BeanE");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Inside @preDestroy in BeanE");
    }
}
