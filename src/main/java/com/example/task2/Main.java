package com.example.task2;

import com.example.task2.beans.*;
import com.example.task2.config.AppConfigTwo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigTwo.class);

        System.out.println("--------------End of Context init-----------------------------");

        for (String str: context.getBeanDefinitionNames()) {
            System.out.println(str);
        }

        System.out.println("--------------End of Context.getBeanDefinitionNames()-----------------------------");
        System.out.println();

        System.out.println("-------------------------Beans.toString()---------------------");
        BeanA beanA = context.getBean(BeanA.class);
        System.out.println(beanA);

        BeanB beanB = context.getBean(BeanB.class);
        System.out.println(beanB);

        BeanC beanC = context.getBean(BeanC.class);
        System.out.println(beanC);

        BeanD beanD = context.getBean(BeanD.class);
        System.out.println(beanD);

        BeanE beanE = context.getBean(BeanE.class);
        System.out.println(beanE);

        BeanF beanF = context.getBean(BeanF.class);
        System.out.println(beanF);
        System.out.println("-------------------------Beans.toString()---------------------");

        context.close();
    }
}
