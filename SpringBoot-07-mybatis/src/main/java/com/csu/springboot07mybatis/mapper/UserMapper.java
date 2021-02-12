package com.csu.springboot07mybatis.mapper;

import com.csu.springboot07mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //表示了这是一个mybatis的mapper类
@Repository       //Dao层
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
