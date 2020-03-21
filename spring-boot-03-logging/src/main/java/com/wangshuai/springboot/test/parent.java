package com.wangshuai.springboot.test;

import org.springframework.stereotype.Component;

@Component
public class parent implements sickBehaviour{

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

    @Override
    public void play() {
        System.out.println("父母的play函数");
    }
}
