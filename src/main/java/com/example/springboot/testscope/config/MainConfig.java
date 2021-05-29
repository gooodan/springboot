package com.example.springboot.testscope.config;

import com.example.springboot.testscope.component.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig {

    @Bean
//    @Scope(value = "prototype")
//    @Lazy
    public Person person() {
        return new Person();
    }
}
