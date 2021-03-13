package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    // UserMapperImpl2实现类继承SqlSessionDaoSupport，省掉了注入的过程
    // 不需要自己再写SqlSessionTemplate，因为父类写好了
    @Override
    public List<User> selectUser() {
//        SqlSession sqlSession = getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        return mapper.selectUser();
        // 官方建议使用一行
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
