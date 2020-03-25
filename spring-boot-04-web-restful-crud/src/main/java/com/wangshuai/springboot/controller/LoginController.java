package com.wangshuai.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    /**
     * 原映射方式为(比较麻烦)：
     * @RequestMapping(value = "/user/login",method = RequestMethod.POST)
     * 使用RESTful风格处理请求
     * @return
     */
    @PostMapping("/user/login")
    /**
     * @RequestParam
     * 1.表示请求参数必须提交
     * 2.且返回值类型必须为String：修改html<name="username"   name="password">
     */
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String ,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "wangshuai".equals(password)){
            /**
             * 添加HttpSession：只要用户登录了就会存在于会话session中
             */
            session.setAttribute("userLogined",username);//设置新属性和值
            /**
             * redirect:表示前缀
             * /表示当前项目
             * main.html表示urlpath
             */
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
    /**问题1：为什么登录失败后样式变了
     * css使用相对路径
     * 修改<link href="asserts/css/bootstrap.min.css" th:href="@{webjars/bootstrap/4.4.1-1/css/bootstrap.css}" rel="stylesheet">
     * 为<link href="asserts/css/bootstrap.min.css" th:href="@{/webjars/bootstrap/4.4.1-1/css/bootstrap.css}" rel="stylesheet">
     * 表示从当前项目资源寻找
     */
    /**问题2：为什么点击sign in按钮就能发送“http://localhost:8080/crud/user/login”请求
     * [Form表单、四种常见的POST请求提交数据方式](https://blog.csdn.net/bigtree_3721/article/details/82809459)
     */
}
