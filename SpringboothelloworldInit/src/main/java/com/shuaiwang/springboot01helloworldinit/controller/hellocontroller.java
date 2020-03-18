package com.shuaiwang.springboot01helloworldinit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
///**
// * 这个类所有方法返回的数据，直接写给浏览器（如果是对象，还可转为Json数据）
// */
//@Controller
@RestController
public class hellocontroller {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world init";
    }
    /**
     * RESTAPI方式：
     * 也就是发一个请求@RequestMapping("/hello")
     * 把数据直接交给浏览器return "hello world init";
     * 而不是页面跳转
     * --------填坑--------
     */
}
