package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这个类也会Spring容器托管，注册到容器中，因为他本米就是一个@Component
//@Configuration表示这是一个配置类，就像我们之前看的beans.xml，类似于<beans>标签
//ComponentScan为扫描这个包下的所有注解，相当于<context:component-scan base-package="com.kuang"/>
//不扫描的话也可以，就需要手动@Bean
//@ComponentScan("com.kuang.pojo")
//@Import(KuangConfig2.class)
@Configuration
public class KuangConfig {

    //注册一个bean, 就相当于我们之前写的一个bean 标签
    //这个方法的名字，就相当于bean 标签中的id 属性 ->getUser
    //这个方法的返同值,就相当于bean 标签中的class 属性 ->User
    @Bean
    public User getUser(){
        return new User();  //就是返回要注入到bean的对象!
    }

    @Bean
    public User user(){
        return new User();
    }
}
