package com.csu.dao;

import com.csu.domain.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 保存学生
     * @param s
     * @return
     */
    int save(Student s);

    /**
     * 根据id删除多个学生
     * @param ids
     * @return
     */
    int deleteByIds(String[] ids);


    /**
     * 保存多个学生
     * @param studentList
     * @return
     */
    int saves(List<Student> studentList);
}
