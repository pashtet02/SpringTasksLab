package com.example.task2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(BeanB.class);
        bd.setInitMethodName("anotherInitMethod");

        ((DefaultListableBeanFactory) configurableListableBeanFactory)
               .registerBeanDefinition("BeanB", bd);
    }
}
