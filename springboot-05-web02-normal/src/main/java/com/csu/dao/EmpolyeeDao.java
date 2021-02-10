package com.csu.dao;

import com.csu.pojo.Department;
import com.csu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository     //给spring托管
public class EmpolyeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();     //创建一个员工表

        employees.put(1001,new Employee(1001,"张三","123456@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"李四","123457@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"王五","123458@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"赵六","123459@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"吴七","123450@qq.com",0,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee empolyee){
        if (empolyee.getId() == null){
            empolyee.setId(initId++);
        }
        empolyee.setDepartment(departmentDao.getDepartmentById(empolyee.getDepartment().getId()));

        employees.put(empolyee.getId(),empolyee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过ID查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
