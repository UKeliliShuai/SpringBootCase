package com.shuaiwang.springboot.test;

import org.springframework.context.annotation.Bean;

public class student implements sickBehaviour{

    @Override
    public String eat() {
        return null;
    }

    @Override
    public String eat(int p1) {
        return null;
    }

    @Override
    public boolean eat(int p1, boolean p2) {

        return p2;
    }

    @Override
    public int sleep() {

        return 0;
    }

    @Bean
    @Override
    public void play() {
        System.out.println("学生的play函数");
    }
}
