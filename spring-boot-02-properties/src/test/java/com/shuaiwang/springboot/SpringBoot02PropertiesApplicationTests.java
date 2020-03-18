package com.shuaiwang.springboot;

import com.shuaiwang.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 1.Spring单元测试
 *
 * 2.@RunWith(SpringRunner.class)表示用spring驱动器跑程序，而不是junit
 * <dependency>
 *   <groupId>junit</groupId>
 *   <artifactId>junit</artifactId>
 *   <version>RELEASE</version>
 *   <scope>test</scope>
 * </dependency>
 *
 * 3.可以在测试期间类似编码一样很方便的进行自动注入
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02PropertiesApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void testHelloService(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
