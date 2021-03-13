package com.kuang.pojo;

public class User {
    String name;

    public User(){
        System.out.println("323232323");
    }
//    public User(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

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
