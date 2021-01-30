package com.csu.dao;

import com.csu.pojo.User;

import java.util.List;
import java.util.Map;

/*
Dao接口,以后写作Mapper
 */
public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);



}
