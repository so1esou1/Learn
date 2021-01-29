package com.csu.dao;

import com.csu.domain.Student;

public interface StudentDao {
    /**
     * 保存学生
     * @param s
     * @return
     */
    int save(Student s);

    /**
     * 保存学生
     * @param id
     * @param name
     * @param birth
     * @return
     */
    int save2(String id, String name, String birth);
}
