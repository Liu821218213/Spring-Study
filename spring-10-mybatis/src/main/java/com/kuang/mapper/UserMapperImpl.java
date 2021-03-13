package com.kuang.mapper;

import com.kuang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    // 我们的所有操作，在原来mybatis中使用sqlSession来执行，
    // 现在都使用SqlSessionTemplate模板，两者操作相同
    private SqlSessionTemplate sqlSession;  // 私有化sqlSession

    // Spring万物皆注入，这里需要一个set来注入sqlSession
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
