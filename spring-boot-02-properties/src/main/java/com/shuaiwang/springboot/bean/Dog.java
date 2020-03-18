package com.shuaiwang.springboot.bean;

import lombok.Data;

/**
 * Dog class
 *
 * @author wangshuai
 * @date 2020/0317
 * 作用：使用yml文件设置对象属性
 */
@Data
public class Dog {
    private String name;
    private Integer age;
}
