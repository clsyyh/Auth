package org.auth.dao;

import org.auth.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleDao {
    public UserRole findById(Integer id);

    public List<UserRole> findByUserId(Integer userId);
    public int deleteByUserId(Integer roleId);

    //一个用户对应多个角色，批量插入
    public int save(List<UserRole> userRoles);
    public List<UserRole> findUserRoles(List<Integer> ids);
    public List<UserRole> findAllUserRoles();
}
