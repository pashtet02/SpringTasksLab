package com.example.task1;

import com.example.task1.beans1.BeanB;
import com.example.task1.config.AppConfigOne;
import com.example.task1.config.AppConfigTwo;
import com.example.task1.others.GeneralBean;
import com.example.task1.others.OtherBeanA;
import com.example.task1.beans1.BeanC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigOne.class, AppConfigTwo.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        BeanB beanA = (BeanB) context.getBean("beanB");
        beanA.getOtherBeanB().setOtherName("test");
        System.out.println(beanA.getOtherBeanB().getOtherName());
        context.getBean(GeneralBean.class).printCars();
        OtherBeanA otherBeanA = context.getBean(OtherBeanA.class);
        System.out.println(otherBeanA);

        GeneralBean generalBean = context.getBean(GeneralBean.class);
        System.out.println(generalBean.getCar());

        BeanC beanC = context.getBean(BeanC.class);
        System.out.println(beanC.getOtherBeanC());
    }


}
