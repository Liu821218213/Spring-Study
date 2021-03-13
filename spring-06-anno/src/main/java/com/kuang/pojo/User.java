package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="com.pojo.User"></bean>
//Component组件
@Component
public class User {
    @Value("张三")
    public String name;
//    public String name = "张三";
}
