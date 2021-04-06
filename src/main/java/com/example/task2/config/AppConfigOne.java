package com.example.task2.config;

import com.example.task2.beans.MyBeanFactoryPostProcessor;
import com.example.task2.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigOne {
    @Bean
    public static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public static MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

}
