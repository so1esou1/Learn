import com.csu.pojo.Student;
import com.csu.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());

        /*输出:
        Student{name='lily', address=Address{address='null'},
        books=[红楼梦, 水浒传, 西游记, 三国演义],
        hobbys=[听歌, 敲代码, 看电影],
        card={身份证=123456, 银行卡=654321},
        games=[LOL, COC, BOB],
        info={学号=8102181508, 性别=男, 姓名=小明},
        wife='null'}
         */
    }

    @Test
    //测试p命名空间注入
    public void test2(){
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user);
    }

    @Test
    //测试c命名空间注入
    public void test3(){
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2",User.class);
        System.out.println(user);
    }

}
