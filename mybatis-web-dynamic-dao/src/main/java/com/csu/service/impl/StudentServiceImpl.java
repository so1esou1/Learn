package com.csu.service.impl;

import com.csu.crm.SqlSessionUtil;
import com.csu.crm.StudentService;
import com.csu.dao.StudentDao;
import com.csu.dao.impl.StudentDaoImpl;
import com.csu.domain.Student;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getCurrentSqlSession().getMapper(StudentDao.class);
    @Override
    public boolean save(Student s) {
        return studentDao.save(s) == 1;  //如果返回条数是1，说明是true
    }

    @Override
    public boolean save2(String id, String name, String birth) {
        return studentDao.save2(id,name,birth) == 1;
    }
}

