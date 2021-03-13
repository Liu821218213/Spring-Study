package com.kuang.demo04_GeneralProxy;


public class Client {
    //Proxy用来生成动态代理实例
    public static void main(String[] args) {
        //真实角色（要改的业务对象）
        UserServiceImpl userService = new UserServiceImpl();

        //有代理（建立了一个代理通道、代理器）
        ProxyInvocation pih = new ProxyInvocation();

        //代理谁
        pih.setTarget(userService);

        //谁代理（Java专用代理proxy）
        UserService proxy = (UserService) pih.getProxy();

        //代理什么
        proxy.delete();
    }

}
