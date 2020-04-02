package com.springboot.web.dao;

import com.springboot.web.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 实例化 部门模型
 * 对应 entities/Department模型
 */
@Repository
public class DepartmentDao {
    //定义一个Map类型的 Department 变量 保存成员信息 key=Integer类型 存放id,value为 entities/Department模型的 对象类型
    private static Map<Integer,Department> departments = null;

    //静态代码块
    //定义默认的 部门id与部门名称
    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"人事部"));
        departments.put(102,new Department(102,"工程部"));
        departments.put(103,new Department(103,"技术部"));
        departments.put(104,new Department(104,"后勤部"));
    }
    //获取成员数据 返回的数据类型是 Collection 集合Department对象
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //通过部门 id 获取 id对应的部门数据 返回 Department数据类型
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
