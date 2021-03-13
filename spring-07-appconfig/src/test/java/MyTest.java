import com.kuang.config.KuangConfig;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        //如果完全使用了配置类方式去做,我们就只能通过 Annotationconfig 上下文来获取容器,通过配置类的class对象加载!
        ApplicationContext context = new AnnotationConfigApplicationContext(KuangConfig.class);
        User user = context.getBean("getUser", User.class);  //Bean中的id，就是方法名
        System.out.println(user);
        User user2 = context.getBean("user", User.class);
        System.out.println(user2);
    }
}
