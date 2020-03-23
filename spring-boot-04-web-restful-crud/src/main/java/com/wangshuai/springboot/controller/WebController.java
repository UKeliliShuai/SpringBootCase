package com.wangshuai.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Demo web class
 *
 * @author wangshuai
 * @date 2020/03/20
 */
@Controller
public class WebController {

    @ResponseBody
    @RequestMapping("/hello")
    public String helloWeb(){
        return "hello web!";
    }
    /**
     * 设置场景
     * 查出一些数据，在页面显示
     */
    @RequestMapping("/success")
    public String success1(Map<String,Object> map){
        map.put("first","helloword");
        map.put("wangshuai","成功");
        map.put("Keys", Arrays.asList("V1","V2","V3"));
        return "success";
    }

    /**
     * - 之前疯狂报错ERROR的原因：
     * ERROR 6884 --- [nio-8080-exec-1] org.thymeleaf.TemplateEngine:
     * [THYMELEAF][http-nio-8080-exec-1] Exception processing template "text":
     * Error resolving template [text], template might not exist or might not
     * be accessible by any of the configured Template Resolvers
     * 也是我对controller 返回值的疑问
     * - 经过实验：
     * + return与函数名无关
     * + return的是@RequestMapping("/text")中的"text"
     * + 且return与HTML模板的文件名对应
     * - 再次实验：
     * + requestmapping后是浏览器访问资源的URL
     * + return只是必须与资源名称（HTML）对应
     * @param map
     * @return
     */
    @RequestMapping("/textTest111")
    public String textTest(Map<String,Object> map){
        List list = new ArrayList();
        list.add("张三");list.add("李四");list.add("王五");
        map.put("text","<h2>转义文本</h2>");
        map.put("first","helloword");
        map.put("wangshuai","成功");
        map.put("Keys", Arrays.asList("V1","V2","V3"));
        map.put("arr1", list);
        return "textTest";
        /**
         * 从这点可以看出，如前所述，模板引擎（thyemleaf程序）
         * - 开箱即用
         * - Data+template经过tempEngine模板引擎会写成新的页面
         */

    }
    /**20200323
     * 上述疑问的实质是模板引擎的拼接字符串操作
     * 前缀：XXXXtemplates
     * 后缀：.html
     * 中间：return的字符串
     */
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
