package com.csu.dao;

import com.csu.pojo.User;
import com.csu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            //第二步：执行SQL
            //方式一:
            /*UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();*/

            //方式二（这种方式要强转，还是用第一种好）:
            List<User> userList = sqlSession.selectList("com.csu.dao.UserDao.getUserList");
            //遍历
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    //测试根据id查询用户的方法
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();    //这是固定不变的

        UserDao mapper = sqlSession.getMapper(UserDao.class);//获取接口
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();    //这是固定不变的
    }

    @Test
    //测试增加用户的方法
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();    //这是固定不变的

        UserDao mapper = sqlSession.getMapper(UserDao.class);//获取接口
        //增删改需要提交事务！！！
        int res = mapper.addUser(new User(4,"赵四","123459"));
        if (res > 0){     //大于0说明插入成功了
            System.out.println("插入成功！");
        }
        //此处提交事务
        sqlSession.commit();

        sqlSession.close();    //这是固定不变的
    }

    @Test
    //测试修改用户的方法
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(4,"昭四","123450"));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    //测试删除用户的方法
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    //测试万能的Map增加用户
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        //
        Map<String, Object> map = new HashMap<>();
        map.put("userid",5);
        map.put("username","吴七");
        map.put("password","123466");

        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //测试万能的Map查找用户
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<String,Object>();


        sqlSession.close();
    }


    @Test
    //测试模糊查询
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> userList = mapper.getUserLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    /*
    这种写法会存在sql注入的问题
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserLike("李");   //改动了这里
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
     */

}
