package com.csu;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.session.SqlSessionFactory;


import java.util.HashMap;
import java.util.Map;

public class MyBatisTest01 {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSessionFactory factory = new SqlSessionFactoryBuilder().
                    build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = factory.openSession();
            //insert
            Map<String,String> studentMap = new HashMap<>();
            studentMap.put("xuehao","333");
            studentMap.put("xingming","lisi");
            studentMap.put("shengri","1980-12-11");
            int count = sqlSession.insert("save",studentMap);
            System.out.println(count);


            sqlSession.commit();
        }catch (Exception e){
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
