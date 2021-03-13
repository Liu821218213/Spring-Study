package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //lombok的Data注释可以自动生成get和set方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造
public class User {
    private int id;
    private String name;
    private String pwd;
}
