import com.kuang.pojo.User;
import com.kuang.pojo.UserT;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        // new 的时候已经创建了spring容器，所以对象已经在容器中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserT userT = (UserT) context.getBean("tt2");
        System.out.println(userT);
    }
}
