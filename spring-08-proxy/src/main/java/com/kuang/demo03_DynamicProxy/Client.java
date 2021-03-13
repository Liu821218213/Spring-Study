package com.kuang.demo03_DynamicProxy;

public class Client {
    //掌握：Proxy用来生成动态代理实例，InvocationHandler调用处理程序并返回结果
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色：现在没有
        ProxyInvocation pih = new ProxyInvocation();
        // 动态代理个人的理解：
        // 这里更像new了一个“代理器”，声明了有代理这回事（告诉Java，我需要代理，实现用户的新需求！），
        // 至于代理谁，谁代理，代理的什么事，是下面三步要做的事，
        // 建议结合着反射的思想来理解，甚至有必要画图来表示一下反射的机制，
        // 实际业务生产中，不方便改底层代码来改需求，所以需要借助“代理”，
        // 这个代理其实就是一个反射，动态代理并不需要new不同的代理人物，而是通过代理类Proxy来实现，
        // 我更愿意称这个代理类Proxy为一个“代理器”，是java为了方便我们而创建的动态代理。


        //通过调用程序处理角色来处理我们要调用的接口对象（代理谁）
        pih.setRent(host);

        //这里的proxy是动态生成的，我们并没有生成（生成代理，谁代理）
        Rent proxy = (Rent) pih.getProxy();

        //执行代理的方法（实现代理内容）
        proxy.rent();

    }

}
