package com.csu.mapper;
/*
使用第二种方式SqlSessionDaoSupport进行整合
 */
import com.csu.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    public List<User> selectUser() {
        /*SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);*/
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
