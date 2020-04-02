package com.springboot.web.dao;

import com.springboot.web.entities.Department;
import com.springboot.web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 实例化 部门成员信息
 * 成员的部门信息由 DepartmentDao 关联获取
 *
 */

@Repository
public class EmployeeDao {
    //定义一个Map类型的 Employess 变量 保存成员信息 key=Integer类型 存放id,value为 entities/Employee模型的 对象类型
   private static Map<Integer, Employee> employees = null;

   //首先自动化配置 DepartmentDao
    @Autowired
    private DepartmentDao departmentDao;
    //定义部门成员的墨认信息
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"E-AA","aa@qq.com",1,new Department(101,"D-AA")));
        employees.put(1002,new Employee(1002,"E-BB","bb@qq.com",2,new Department(102,"D-BB")));
        employees.put(1003,new Employee(1003,"E-CC","cc@qq.com",1,new Department(103,"D-DD")));
    }
    //定义一个 成员id 如果 保存数据时 id 自增
    private static  Integer initId = 1004;

    //保存数据,接收employee 参数 成员属性的对象集合
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        //添加部门信息,先通过employee.getDepartment().getId()获取到这个成员部门id对应用的部门信息
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        //添加成员信息
        employees.put(employee.getId(),employee);
    }

    //获取所有成员信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //根据成员 id 获取成员信息
    public Employee get(Integer id){
        return employees.get(id);
    }
    //根据成员 id 移除成员

    public void remove(Integer id){
        employees.remove(id);
    }



}
