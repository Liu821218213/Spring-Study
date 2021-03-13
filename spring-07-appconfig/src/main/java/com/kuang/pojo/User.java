package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//这里这个注解的意思,就是说明这个类被Spring接管了,注册到了容器中
@Component
@Scope("prototype")
public class User {

    //属性注入值
    //@Value("kuang666")
    public String name;

    public String getName() {
        return name;
    }

    //也可以在set方法上注入值
    @Value("kuang666")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
