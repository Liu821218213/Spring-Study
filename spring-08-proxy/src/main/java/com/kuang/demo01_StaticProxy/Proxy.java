package com.kuang.demo01_StaticProxy;

//代理
public class Proxy {

    //房东
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent(){
        seeHouse();
        host.rent();
        hetong();
        fee();
    }
    public void seeHouse(){
        System.out.println("房东带你看房子");
    }

    public void hetong(){
        System.out.println("签合同");
    }

    public void fee() {
        System.out.println("收中介费");
    }
}
