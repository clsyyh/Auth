package org.auth.dao;

import org.auth.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    //动态分页查询(employee&pageModel)
    List<Employee> selectByPage(Map<String,Object> params);
    //动态查询员工总数(employee)
    int count(Map<String,Object> params);
    Employee selectById(int id);
    int deleteById(int id);
    //动态插入
    int save(Employee employee);
    //动态更新
    int update(Employee employee);
    //查询所有员工
    List<Employee> findAllEmployees();
}
