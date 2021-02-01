package com.csu.dao;

import com.csu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    //查询老师
    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
