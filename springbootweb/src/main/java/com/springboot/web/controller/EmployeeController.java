package com.springboot.web.controller;

import com.springboot.web.dao.DepartmentDao;
import com.springboot.web.dao.EmployeeDao;
import com.springboot.web.entities.Department;
import com.springboot.web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * 员工管理（CURD）控制器
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工信息返回列表
    @GetMapping("/emps")
    public String list(Model model){
        //查询所有员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //将查出来的员工信息返回到请求域中
        model.addAttribute("emps",employees);
        //返回信息到"emp/list"页面
        return "emp/list";
    }

    //添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查询所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求是请求参数的名字和入参对象里面的属性名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存的员工信息："+employee);
        //保存员工信息
        employeeDao.save(employee);
        //redirect:表示重定向到某个地址    "/"代表当前项目
        //forward:表示转发到某个地址
        return "redirect:/emps";
    }

    //进入修改员工页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //返回到修改页面
        return "emp/add";
    }

    //修改员工
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeDao.remove(id);
        return "redirect:/emps";
    }
}
