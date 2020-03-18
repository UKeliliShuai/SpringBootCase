package com.shuaiwang.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@Value("${person.lastname}")
    private String lastname;

    //@RequestMapping("/helloConfig")
    public String hellocontroller(){
        return "hello"+lastname;
    }
}
