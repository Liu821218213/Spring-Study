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
/*
mybatis的配置流程：
1. 编写实体类
2. 编写接口
3. 编写核心配置文件mybatis-config.xml
4. 编写UserMapper.xml
5. 测试
*/
    // MyBatis编写顺序：
    // User、UserMapper、UserMapper.xml
    // mybatis-config.xml（核心配置文件）、db.properties（常量库）
    // MyTest
    @Test
    public void test_MyBatis() throws IOException {
        // 注意，这里将原本MyBatis内容里面的MybatisUtils与测试类整合到了一起，实际步骤还是一样
        // 使用Mybatis第一步：获取SqlSessionFactory对象
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 自动提交事务设置为true，默认为false，返回值即为SqlSession实例，可以执行数据库命令
        SqlSession sqlSession = sessionFactory.openSession(true);

        // getMapper面向接口编程，反射拿接口的class，而UserMapper.xml只是接口的一个实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper对象为当前session对象，可以执行它的selectUser方法
        List<User> userList = mapper.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

/*
mybatis-spring-整合方式一：需要掌握原理
编写实体类之后：
1. 编写数据源配置datasource
2. sqISessionFactory
3. sqISessionTemplate（相当于sqISession）
4. 需要给接口加实现类(new)UserMapperImpl
5. 将自己写的实现类，注入到Spring中，applicationContext.xml中的userMapper
6. 测试！
*/
    // MybatisToSpring编写顺序：
    // User、UserMapper、UserMapper.xml、
    // spring-dao.xml（spring绑定dao层，绑定MyBatis）、
    // UserMapperImpl、
    // applicationContext.xml（项目中用来汇总beans.xml文件）、
    // mybatis-config-2.xml（一些MyBatis的配置）、
    // MyTest
    @Test
    public void test_MybatisToSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }


// mybatis-spring-整合方式二：SqlSessionDaoSupport（掌握即可，新版特性）
// 继承了SqlSessionDaoSupport，就不用手动再写UserMapperImpl实现类中的
// SqlSessionTemplate和有参的setSqlSession的造函数，因为父类已经完成了,
// 直接getSqlSession()即可得到从父类而来的SqlSession
    @Test
    public void test_MybatisToSpring2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}
