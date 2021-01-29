package com.csu.service.impl;

import com.csu.crm.StudentService;
import com.csu.dao.StudentDao;
import com.csu.dao.impl.StudentDaoImpl;
import com.csu.domain.Student;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public boolean save(Student s) {
        return studentDao.save(s) == 1;  //如果返回条数是1，说明是true
    }
}
