package com.wangshuai.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前执行
     * 弹幕中说：AOP和这个是一个原理，我看也挺像的！
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**操作request可以获取到的属性有：
         * session
         * Attribute
         */
        Object user = request.getSession().getAttribute("userLogined");
        if(user == null){
            request.setAttribute("msg","请先登录您的账户！");
            /**未登录，返回登陆首页
             * getRequestDispatcher获取请求转发器
             *      其中getRequestDispatcher不像普通javaBean获取属性值，不带参数
             *      而是获取有指向的RequestDispatcher("/index.html")----->理解为向量
             * 将操作完的request转发(forward)
             */
            request.getRequestDispatcher("/index.html").forward(request,response);
            /**系统调试
             * 问题：为什么getRequestDispatcher要加上String类型
             * 结果：通过观看源码难以接受，似懂非懂的
             * 方式：
             * 1.查看声明与实现，注意接口集成关系
             * 2.直接debug调试
             */
            return false;
        }else{
            //已登录，放行请求
            return true;
        }
    }
}
