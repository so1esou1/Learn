package com.csu.service.impl;

import com.csu.crm.StudentService;
import com.csu.dao.StudentDao;
import com.csu.dao.impl.StudentDaoImpl;
import com.csu.domain.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Map<String, Object> getPageByCondition(Map<String, Object> conditionMap) {
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",studentDao.getTotalByCondition(conditionMap));
        pageMap.put("datalist",studentDao.getDatalistByCondition(conditionMap));
        return null;
    }


}
