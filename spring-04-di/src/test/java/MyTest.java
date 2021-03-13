import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student user = (Student) context.getBean("student");
        System.out.println(user);
//        Student{
//        name='请讲',
//        address=Address{address='南京'},
//        books=[三国, 西游, 水浒, 红楼],
//        hobbies=[唱, 跳, Rap, 篮球],
//        card={username=张三,
//              password=123456},
//        games=[lol, 王者荣耀, 斗地主],
//        wife='null',
//        info={name=李四,
//              id=20210312}}
    }

    @Test
    public void testp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("pcBeans.xml");
        User userp = context.getBean("pUser", User.class);
        System.out.println(userp);
        User userc = context.getBean("cUser", User.class);
        System.out.println(userc);

//        单例模式：Spring默认
        User userp2 = context.getBean("pUser", User.class);
        System.out.println(userp == userp2);

//        原型模式：每次从容器中getBean的时候，都产生一个新对象
        User userc2 = context.getBean("cUser", User.class);
        System.out.println(userc == userc2);
    }
}
