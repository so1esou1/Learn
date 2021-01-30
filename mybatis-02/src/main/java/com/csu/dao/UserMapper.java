package com.csu.dao;

import com.csu.pojo.User;

import java.util.List;
import java.util.Map;

/*
Dao接口,以后写作Mapper
 */
public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //insert增加一个用户
    int addUser(User user);

    //update修改用户
    int updateUser(User user);

    //delete删除一个用户
    int deleteUser(int id);


}
