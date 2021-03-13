package com.kuang.demo03_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//掌握：Proxy用来生成动态代理实例，InvocationHandler调用处理程序并返回结果
//用这个类，自动生成代理类
public class ProxyInvocation implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质就是通过反射来实现
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();
        sign();
        return result;
    }

    public void seeHouse() {
        System.out.println("看房子");
    }

    public void fare() {
        System.out.println("收中介费");
    }

    public void sign() {
        System.out.println("签合同");
    }
}
