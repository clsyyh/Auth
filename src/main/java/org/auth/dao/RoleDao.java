package org.auth.dao;

import org.auth.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    public int save(Role role);
    public int update(Role role);
    public int deleteRoleById(Integer id);
    public Role findRoleById(Integer id);
    public List<Role> findRoles(List<Integer> ids);
    public List<Role> findAllRoles();
}
