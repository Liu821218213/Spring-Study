package com.kuang.demo02_AOP;

// 代理模式
// 这里是用户
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.query();
    }
}
