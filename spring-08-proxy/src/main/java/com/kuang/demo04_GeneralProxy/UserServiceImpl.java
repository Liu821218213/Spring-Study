package com.kuang.demo04_GeneralProxy;

// 真实对象
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新了一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户");
    }

    //改动原有的业务代码，在公司是大忌！
}
