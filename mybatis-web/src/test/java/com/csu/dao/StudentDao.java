package com.csu.dao;

import com.csu.domain.Student;

public interface StudentDao {
    /**
     * 保存学生
     * @param s
     * @return
     */
    int save(Student s);
}
