package com.example.springboot.testscope;

import com.example.springboot.testscope.component.Person;
import com.example.springboot.testscope.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean("person");
        Person person1 = (Person) applicationContext.getBean("person");

        person.setName("张三");
        person.setAge(30);
        System.out.println("person \t" + person.toString());
        System.out.println("person1 \t" + person1.toString());

        person1.setName("李四");
        person1.setAge(40);
        System.out.println("person \t" + person.toString());
        System.out.println("person1 \t" + person1.toString());


        System.out.println(person == person1);

    }

}
