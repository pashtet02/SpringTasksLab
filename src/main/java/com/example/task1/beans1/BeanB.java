package com.example.task1.beans1;

import com.example.task1.others.OtherBeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private String nameB;
    private OtherBeanB otherBeanB;

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }
    public OtherBeanB getOtherBeanB() {
        return otherBeanB;
    }

    @Autowired
    public void setOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    public String getNameB() {
        return nameB;
    }


    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + nameB + '\'' +
                '}';
    }

    public BeanB(String name) {
        this.nameB = name;
    }

    public BeanB() {
    }
}
