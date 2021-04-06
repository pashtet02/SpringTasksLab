package com.example.task1.config;

import com.example.task1.beans3.BeanD;
import com.example.task1.beans3.BeanE;
import com.example.task1.others.GeneralBean;
import com.example.task1.others.OtherBeanA;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.example.task1.beans2"})
public class AppConfigTwo {
    @Bean
    public BeanD beanD(){
        return new BeanD();
    }

    @Bean

    public BeanE beanE(){
        return new BeanE();
    }


    @Bean
    public OtherBeanA othrBnA(){
        System.out.println("Other bean A has been injected!");
        return new OtherBeanA();
    }

    @Bean
    @Primary
    public OtherBeanA othrBnA2(){
        return new OtherBeanA();
    }

    @Bean
    public GeneralBean generalBean(){
        return new GeneralBean();
    }
}
