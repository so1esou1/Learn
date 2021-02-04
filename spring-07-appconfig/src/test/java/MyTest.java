import com.csu.config.MyConfig;
import com.csu.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class MyTest {
    public static void main(String[] args) {
        //如果完全使用配置类方式去做，我们就只能通过AnnotationConfig上下文来获取容器，然后通过配置类的class对象加载

        //使用注解配置类获取
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User getUser = (User)context.getBean("getUser");
        System.out.println(getUser.getName());
    }
}
