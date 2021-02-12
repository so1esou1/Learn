package com.csu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;   //JdbcTemplate是Spring对JDBC的封装，目的是使JDBC更加易于使用

    //查询数据库的所有信息
    //没有实体类，数据库中的东西怎么获取？   Map
    @GetMapping("/userList")
    public List<Map<String,Object>> userlist(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //增
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,pwd) values (4,'小光','212456') ";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    //改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=? where id=" + id;
        //封装
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "小明3";
        jdbcTemplate.update(sql,objects);
        return "updateUser-ok";
    }


    //删
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "deleteUser-ok";
    }
}
