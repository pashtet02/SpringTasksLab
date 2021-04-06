package com.example.task1.beans1;

import com.example.task1.others.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("beanA")
public class BeanA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OtherBeanA getOtherBeanA() {
        return otherBeanA;
    }

    @Qualifier("othrBnA")
    @Autowired
    private OtherBeanA otherBeanA;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                '}';
    }

    public BeanA(String name) {
        this.name = name;
    }

    public BeanA() {
    }
}
