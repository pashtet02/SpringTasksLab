package com.example.task1.beans1;

import com.example.task1.others.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanC {
    private String nameC;

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public OtherBeanC getOtherBeanC() {
        return otherBeanC;
    }

    private OtherBeanC otherBeanC;


    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + nameC + '\'' +
                '}';
    }

    public BeanC() {
    }

    @Autowired
    public BeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }
}
