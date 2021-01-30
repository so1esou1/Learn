package com.csu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
工具类,获取需要的sqlSessionFactory对象---》构建sqlSession
 */
public class MybatisUtils {
    //提升SqlSessionFactory作用域，使getSqlSession()中的SqlSessionFactory能用静态代码块中的SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory;

    //一初始就加载
    static {
        try{
            //这三行都是官方文档给的写法,这三句话是死的，因此做成工具类
            //这是使用mybatis的第一步：获取sqlSessionFactory对象。必须要这样做
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法
    public static SqlSession getSqlSession(){
        /*SqlSession sqlSession = sqlSessionFactory.openSession();  //这个方法就是用来创建工厂的
        return sqlSession;*/

        //简化上面代码
        return sqlSessionFactory.openSession();
        //sqlSession与connection对象类似,可以将二者近似看
    }
}
