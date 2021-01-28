package com.csu;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;
import java.util.Map;

public class MyBatisTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
       try {
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().
                   build(Resources.getResourceAsStream("mybatis-config.xml"));

           //查询所有员工的姓名
           /*List<String> enames = sqlSession.selectList("getEnames");
           for (String ename : enames){
               System.out.println(ename);
           }*/

           //查询smith的部门名称以及月薪
           Map<String,String> map = sqlSession.selectOne("getByEname","SMITH");
           System.out.println(map);

           //查询所有工作岗位是manager的员工，要求查询员工姓名以及部门名称
           List<Map<String,String>> list =  sqlSession.selectList("getByJob","MANAGER");
           System.out.println(list.toString());

           //开启事务
           sqlSession = factory.openSession();
           //提交事务
           sqlSession.commit();
       }catch (Exception e){
           //回滚事务
           if (sqlSession != null) {
               sqlSession.rollback();
           }
       }finally {
           //释放资源
           if (sqlSession != null){
               sqlSession.close();
           }
       }
    }
}
