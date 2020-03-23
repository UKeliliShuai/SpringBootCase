package com.wangshuai.springboot;

import com.wangshuai.springboot.TestStudy.TestThis;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot04WebRestfulCrudApplicationTests {

    public void method1(){
        System.out.println("方法1被调用……");
    }

    @Test
    void contextLoads() {
        //有无this关键字，调用方法看似一样
        method1();
        this.method1();
        method1();
        //悄悄改变属性后，有无this关键字，是否存在区别
        TestThis testThis = new TestThis();
        testThis.SoutP1();
        testThis.setP1(1111);
        testThis.SoutP1();
    }

}
