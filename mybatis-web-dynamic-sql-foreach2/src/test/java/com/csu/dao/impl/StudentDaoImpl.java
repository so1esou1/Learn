package com.csu.dao.impl;

import com.csu.crm.SqlSessionUtil;
import com.csu.dao.StudentDao;
import com.csu.domain.Student;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int save(Student s) {
        return SqlSessionUtil.getCurrentSqlSession().insert("save",s);
    }
}
