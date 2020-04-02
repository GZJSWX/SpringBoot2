package com.springboot.web.entities;

/**
 * 部门模型
 * id 部门id
 * departmentName 部门名称
 */
public class Department {
    //定义两个变量 id,departmentName
    private Integer id;
    private String departmentName;

    //空构造方法
    public Department(){}
    //初始化构造方法
    public Department(int id,String name){
        this.id = id;
        this.departmentName = name;
    }

    //get and set (alt+ Insert键->get and set)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // 重写toString (alt+ Insert键->toString)

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
