package com.csu.crm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * mybatis工具类
 */

public class SqlSessionUtil {
    //工具类的方法一般都是私有化，因为工具类的使用不需要实例化
    private SqlSessionUtil(){}


    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>(); //不能写进getCurrentSqlSession()方法里面，不然不符合一个SqlSession

    //类加载的时候初始化SqlSessionFactory对象，只初始化一次
    static{
        try{
            factory = new SqlSessionFactoryBuilder().
                    build(Resources.getResourceAsStream("mybatis-config.xml"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 获取当前线程中的SqlSession对象
     * @return
     */
    public static SqlSession getCurrentSqlSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession();
            local.set(sqlSession);//向t1线程上绑定sqlSession对象
        }
        return sqlSession;
    }

    /**
     * 释放资源
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
            //非常重要
            local.remove();  //解除SqlSession对象与线程t1的绑定关系
            /*
            关闭SqlSession为何将SqlSession从ThreadLocal中移出？
                tomcat服务器自带“线程池”，用过的线程t1，下一次可能还会使用线程t1
                再用会报错:Executor is Colsed
                加入tomcat中没有线程池，每一次请求过来都将是一次全新的线程，
                这个不删，在并发量大的时候会出现问题，会创建许多个对象
             */
        }
    }

    /**
     * 回滚事务
     * @param sqlSession
     */
    public static void rollback(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.rollback();

        }
    }
}
