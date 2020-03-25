package com.wangshuai.springboot.config;

import com.wangshuai.springboot.component.LoginHandlerInterceptor;
import com.wangshuai.springboot.component.MyLocaleResover;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
                registry.addViewController("/main.html").setViewName("dashboard");
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
    /** 注册拦截器
     * 拦截器在component写完后一定要配置出来
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**SpringBoot自动拦截静态资源
         * 拦截器机制的理解：
         * 1.除了excludePathPatterns("/index.html","/","/user/login")
         * 2.所有的addPathPatterns("/**")都要经过拦截器
         * 3.自定义拦截器内部的public boolean preHandle(...)函数
         * 4.springboot2.0以上要设置静态资源放行
         */
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/index.html","/","/user/login").excludePathPatterns("/asserts/**");
    }
}
