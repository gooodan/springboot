package com.example.springboot.testscope.component;

import lombok.Data;

@Data
public class Person {

    private int age;

    private String name;

    public Person() {
        System.out.println("Person 构造方法");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
