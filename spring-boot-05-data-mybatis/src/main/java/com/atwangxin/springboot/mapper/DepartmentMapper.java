package com.atwangxin.springboot.mapper;

import com.atwangxin.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(dept_name) values(#{deptName})")
    public int insertDept(Department department);

    @Update("update department set dept_name=#{deptName} where id=#{id}")
    public int updateDept(Department department);
}
