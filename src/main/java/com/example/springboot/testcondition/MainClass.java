package com.example.springboot.testcondition;

import com.example.springboot.testcondition.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("beanName \t" + beanName);
        }
    }
}
