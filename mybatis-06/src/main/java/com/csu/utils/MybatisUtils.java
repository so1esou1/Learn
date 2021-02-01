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
    private static SqlSessionFactory sqlSessionFactory;

    //一初始就加载
    static {
        try{

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
       //将这里设置为true,以后所有的事务都不再需要手动commit了
        return sqlSessionFactory.openSession(true);
        //代码里面还是尽量避免自动提交
    }
}
