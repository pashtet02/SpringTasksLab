package com.example.task2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Inside postProcessBeforeInitialization() " + beanName);

        if (bean instanceof MyBean){
            if (((MyBean) bean).getName() == null) {
                System.out.println("Hey, you have not valid name, Change it! I could throw an Exception, but i did not :)");
                //throw new IllegalArgumentException();
            }

            if (((MyBean) bean).getValue() < 0) {
                System.out.println("Hey, you have not valid value < 0, Change it! I could throw an Exception, but i did not :)");
                //throw new IllegalArgumentException();
            }
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Inside postProcessAfterInitialization() " + beanName);
        return null;
    }
}
