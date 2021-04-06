package com.example.task2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA extends MyBean implements InitializingBean, DisposableBean{

    @Override
    public void destroy() throws Exception {
        System.out.println("Message from beanA.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Message from beanA.afterPropertiesSet()");
    }
}
