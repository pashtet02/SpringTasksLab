package com.example.task2.config;

import com.example.task2.beans.BeanE;
import com.example.task2.beans.BeanF;
import com.example.task2.beans.BeanA;
import com.example.task2.beans.BeanB;
import com.example.task2.beans.BeanC;
import com.example.task2.beans.BeanD;
import org.springframework.context.annotation.*;

@Configuration
@Import(com.example.task2.config.AppConfigOne.class)
@PropertySource("classpath:application.properties")
public class AppConfigTwo {
    @Bean("beanA")
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanB BeanB() {
        return new BeanB();
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean("beanE")
    public BeanE getBeanE() {
        return new BeanE();
    }


    @Bean("beanF")
    @Lazy
    public BeanF getBeanF() {
        return new BeanF();
    }
}
