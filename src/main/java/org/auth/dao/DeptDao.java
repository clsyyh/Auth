package org.auth.dao;

import org.auth.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptDao {
    /*模糊查询*/
    //动态分页查询(dept&pageModel)
    List<Dept> selectByPage(Map<String,Object> params);
    //动态查询部门总数(dept)
    int count(Map<String,Object> params);
    //查询所有部门信息
    List<Dept> selectAllDept();

    Dept selectById(int id);
    int deleteById(int id);
    //动态插入部门
    int save(Dept dept);
    //动态修改部门
    int update(Dept dept);
}
