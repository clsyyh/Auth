package org.auth.dao;

import org.auth.entity.RoleFunction;

import java.util.List;

public interface RoleFunctionDao {
    public RoleFunction findById(Integer id);

    public List<RoleFunction> findByRoleId(Integer roleId);
    public int deleteByRoleId(Integer functionId);

    //一个角色对应多个权限，批量保存
    public int save(List<RoleFunction> roleFunctions);
}
