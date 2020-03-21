package com.wangshuai.springboot;

import com.wangshuai.springboot.test.student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * runwith无法导入解决方案是使用：
 * 1.重启计算机
 * 2.setting --->build--->maven--->maven home dic--->选择maven bundle 3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot03LoggingApplicationTests {
    /**不知道如何测试
     * 查看千千问的测试解决方案网址
     */
    @Test
    void contextLoads() {
        /**
         * 类的命名有问题
         * 只能自己import了
         */
        student s;

        //ApplicationContext IOC = ApplicationContext
    }

}
