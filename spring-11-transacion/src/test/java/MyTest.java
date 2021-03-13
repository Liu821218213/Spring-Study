import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test_MybatisToSpring2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}

/*
Spring简单User项目创建步骤：
1. 导入pom文件的依赖
2. 建包com.kuang，pojo实体类包下：实体类User
3. mapper包下：接口UserMapper
4. 导入MyBatis配置：resources下的核心配置文件mybatis-config.xml
5. 整合MyBatis：resources下的spring-dao.xml
   1. 配置数据源DataSource
   2. sqlSessionFactory
   3. sqlSession/SqlSessionTemplate
6. 绑定数据库语句接口：UserMapper.xml，在Mapper包下与接口UserMapper同文件名
7. 接口实现类：Mapper包下UserMapperImpl
8. Spring配置文件，将实现类UserMapperImpl注入到Spring里面：resources下的applicationContext.xml
9. Test测试类：MyTest

增加User项目功能的步骤：
1. 增加接口的功能
2. 增加数据库语句
3. 增加接口的实现类功能
*/