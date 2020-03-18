package com.shuaiwang.springboot.config;

import com.shuaiwang.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mAppConfig {
    /**
     * SprinBoot推荐用配置类替代XML文件配置
     * @Bean 为容器中添加bean组件
     * 1.该方法的返回值是“组件”（@bean将方法的返回值添加到容器中）
     * 2.默认的id就是方法名
     * 3.等价于SpringMVC中<Bean id="" class=""></Bean>
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@bean已经添加组件");
        return new HelloService();
    }
}
