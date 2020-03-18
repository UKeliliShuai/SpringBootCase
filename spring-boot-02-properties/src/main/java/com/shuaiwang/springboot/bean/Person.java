package com.shuaiwang.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**第三步
 * 将配置文件中配置的每个属性值，映射到person组件中
 * @ConfigurationProperties----->springboot将本类中所有属性和配置文件中相关的配置进行绑定
 */

/**第四步
 * 处理IDEA提示“Spring boot configuration annotation processor not found in classpath”
 * <!--导入配置文件处理器，配置文件进行绑定就会有提示-->
 * 		<dependency>
 * 			<groupId>org.springframework.boot</groupId>
 * 			<artifactId>spring-boot-configuration-processor</artifactId>
 * 			<optional>true</optional>
 * 		</dependency>
 */

@Data//第一步
@Component//加这个注解是因为只有是容器组件才能使用@ConfigurationProperties
/**
 * @ConfigurationProperties(prefix = "person")
 * @PropertySource(value = {"classpath:mPerson.properties"})
 * 使用自定义配置文件需要二者配合使用
 */
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:mPerson.properties"})
public class Person {
    //@Value("${person.lastname}")
    private String lastname;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    /**
     * 第二步，创建Dog对象
     */
    private Dog mDog;
}
