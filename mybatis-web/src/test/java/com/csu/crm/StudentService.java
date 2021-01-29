package com.csu.crm;

import com.csu.domain.Student;

public interface StudentService {
    /**
     * 保存学生
     * @param s
     * @return
     */
    boolean save(Student s);
}
