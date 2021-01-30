package com.csu.dao;

import com.csu.pojo.User;

import java.util.List;
import java.util.Map;

/*
Dao接口,以后写作Mapper
 */
public interface UserDao {
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


    //使用万能的Map传值，增加用户
    //使用Map有一种好处，就是不用知道数据库里面有什么，只需要去查对应的字段
    int addUser2(Map<String,Object> map);

    //使用Map查询用户
    User getUserById2(Map<String,Object> map);


    //模糊查询
    List<User> getUserLike(String value);
}
