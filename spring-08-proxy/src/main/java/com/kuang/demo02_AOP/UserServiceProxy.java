package com.kuang.demo02_AOP;

// 代理角色
public class UserServiceProxy implements UserService{
    UserServiceImpl userService;

    // Spring注入一个对象，用set方法，而不是无参构造
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add(){
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    // 日志方法
    private void log(String msg) {
        System.out.println("[Debug]"+msg+"方法");
    }
}
