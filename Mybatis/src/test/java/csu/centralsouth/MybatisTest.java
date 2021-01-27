package csu.centralsouth;

import csu.dao.IUserDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/*
mybatis的入门案例

 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    //mybatis的核心API：SqlSession对象
    public static void main(String[] args) throws Exception{
        //1、读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2、创建一个SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3、使用工厂生产一个SqlSession对象
        //事务自动提交机制关闭，等同于conn.setAutpCommit(false);
        //SqlSession对象大致可以看作是Connection，专门用来执行sql语句的一个会话对象
        //开启事务
        SqlSession session = factory.openSession();

        //4、使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        //5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //6、释放资源
        session.close();
        in.close();

    }
}
