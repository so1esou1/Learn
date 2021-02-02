import com.csu.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象，这句话是固定的，只要用xml配置spring就必须写这句话:
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //我们的对象现在都在spring中的管理了，要使用，直接去里面取出来就可以了!
        Hello hello = (Hello)context.getBean("hello");
        System.out.println(hello.toString());
    }
}
