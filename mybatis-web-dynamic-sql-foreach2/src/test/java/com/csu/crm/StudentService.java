package com.csu.crm;

import com.csu.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    /**
     * 保存学生
     * @param s
     * @return
     */
    boolean save(Student s);

    /**
     * 删除多个学生，根据id删除
     * @param ids
     * @return
     */
    boolean deleteByIds(String[] ids);

    /**
     * 保存多个学生
     * @param studentList
     * @return
     */
    boolean saves(List<Student> studentList);

    Object getProxy();


    /**
     *
     * @param conditionMap
     * @return
     */
    Map<String, Object> getPageByCondition(Map<String, Object> conditionMap);
}
