package com.csu.controller;

import com.csu.dao.DepartmentDao;
import com.csu.dao.EmpolyeeDao;
import com.csu.pojo.Department;
import com.csu.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

//员工管理控制器
@Controller
public class EmployeeController {
    //查询所有员工
    @Autowired
    EmpolyeeDao empolyeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = empolyeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")           //限定死只能用get提交，restful风格
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/add";
    }

    @PostMapping("/emp")           //限定死只能用post提交，restful风格
    public String addEmp(Employee empolyee){
        //添加的操作
        empolyeeDao.save(empolyee);          //调用底层业务方法保存员工的信息

        return "redirect:/emps";
    }


    //去员工的修改页面
    @GetMapping("/emp/{id}")                  //链接形式的都是getmapping
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Employee employee = empolyeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update";
    }


    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        empolyeeDao.save(employee);
        return "redirect:/emps";
    }


    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        empolyeeDao.delete(id);
        return "redirect:/emps";
    }
}
