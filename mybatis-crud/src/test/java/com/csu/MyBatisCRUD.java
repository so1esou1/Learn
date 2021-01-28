package com.csu;

import jdk.internal.loader.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/*
使用mybatis完成学生信息的增删改查(查一个/查所有)
 */
public class MyBatisCRUD {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
       try {
           /*String resource = "mybatis-config.xml";
           InputStream inputStream = Resource.getResourceAsStram(resource);
           sqlSessionFactory factory = new SqlSessionFactoryBuilder().build(InputStream);
            */
           //合并以上代码：
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().
                   build(Resources.getResourceAsStream("mybatis-config.xml"));
           //do work:

             //insert:
           /*Student stu = new Student();
           stu.setStuId("111");
           stu.setStuName("zhangsan");
           stu.setStuBirth("2010-10-11");
           int count = sqlSession.insert("save",stu);     //保存，返回值是影响数据库表当中的记录条数
           */

             //update:
           /*Student stu = new Student();
           stu.setStuId("222");
           stu.setStuName("lisi");
           stu.setStuBirth("2010-10-11");
           int count = sqlSession.update("update",stu);
           System.out.println(count);
           */

             //selectOne

           /*Student stu = sqlSession.selectOne("getById","222");
           System.out.println(stu.getStuId());
           System.out.println(stu.getStuName());
           System.out.println(stu.getStuBirth());
            */

             //selectList
           /*List<Student> stuList = sqlSession.selectList("getAll");
           for (Student s : stuList){
               System.out.println(s.getStuId());
           }
           */

             //delete
           int count = sqlSession.delete("deleteById","222");
           System.out.println(count);


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
