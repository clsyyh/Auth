package org.auth.service;

import org.auth.entity.Role;
import org.auth.entity.RoleFunction;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface RoleService {
    public int deleteRoleById(Integer id);
    public Role findRoleById(Integer id);
    public int update(Role role);
    public List<Role> findRoles(List<Integer> ids);
    public List<Role> findAllRoles();
    /*
    一个角色对应多个权限
    保存角色信息，同时保存角色权限对应关系
    */
    public int save(Role role, List<RoleFunction> roleFunctions);
    public List<RoleFunction> findByRoleId(Integer roleId);
}
