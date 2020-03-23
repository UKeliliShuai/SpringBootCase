package com.wangshuai.springboot.config;

import com.wangshuai.springboot.component.MyLocaleResover;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * MyMvcConfig配置类下的WebMvcConfigurer配置组件
     * 属性1是：addViewControllers
     * @return webMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return webMvcConfigurer;
    }

    /**
     * 与组件的名称返回值类型有关而与方法名无关
     * 方法名是组件的类型
     * @return
     */
    @Bean
    public LocaleResolver mylocaleResolver(){
        return new MyLocaleResover();
    }
}
