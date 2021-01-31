package com.csu.dao;

import com.csu.pojo.User;
import com.csu.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);  //提升这个属性的作用域
    //记得导入org.apache.log4j.Logger;这个包


    @Test
    //测试模糊查询
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("测试，进入getUserLike方法成功");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);   //没有使用结果集映射时，打印的是:User{id=1, name='张三', password='null'}      password映射不到

        sqlSession.close();
    }

    @Test
    //测试log4j
    public void testLog4j(){
        //常用的三种方法
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
        //执行后会自动生成log包，包下有qinqin.log文件，保存记录着执行的日志
        //可以在log4j.properties的参数中设置日志生成的各种格式
    }


    @Test
    //测试分页
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();

        map.put("startIndex",0);   //从0开始
        map.put("pageSize",2);     //每页显示2个
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }


    @Test
    //测试rowbounds实现分页，不建议使用
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //通过rowbounds实现分页
        RowBounds rowBounds = new RowBounds(1, 2);


        //通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.csu.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

}
