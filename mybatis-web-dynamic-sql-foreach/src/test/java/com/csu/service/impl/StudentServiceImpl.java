package com.csu.service.impl;

import com.csu.crm.StudentService;
import com.csu.dao.StudentDao;
import com.csu.dao.impl.StudentDaoImpl;
import com.csu.domain.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public boolean save(Student s) {
        return studentDao.save(s) == 1;  //如果返回条数是1，说明是true
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        return studentDao.deleteByIds(ids) == ids.length;
    }

    @Override
    public boolean saves(List<Student> studentList) {
        return studentDao.saves(studentList) == studentList.size();      //等于studentList表示保存成功了

    }


}
