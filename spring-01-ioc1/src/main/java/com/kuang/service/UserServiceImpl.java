package com.kuang.service;

import com.kuang.dao.UserDao;
import com.kuang.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
//    // test1，手动新建对象
//    private UserDao userDao = new UserDaoImpl();

    // test2，使用set注入
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
