import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
    }

    @Test
    public void test1(){
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userServiceImpl = (UserService) classPathXmlApplicationContext.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
