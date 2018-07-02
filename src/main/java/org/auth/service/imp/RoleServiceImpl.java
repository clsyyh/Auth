package org.auth.service.imp;

import org.auth.dao.RoleDao;
import org.auth.dao.RoleFunctionDao;
import org.auth.entity.Role;
import org.auth.entity.RoleFunction;
import org.auth.service.RoleService;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleFunctionDao roleFunctionDao;
    /*
    删除角色的同时删除角色权限对应关系
     */
    public int deleteRoleById(Integer id) {
        roleDao.deleteRoleById(id);
        roleFunctionDao.deleteByRoleId(id);
        return 0;
    }

    public Role findRoleById(Integer id) {
        return roleDao.findRoleById(id);
    }

    public List<Role> findRoles(List<Integer> ids) {
        return roleDao.findRoles(ids);
    }

    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }

    /*
    保存角色的同时保存角色权限对应关系
     */
    public int save(Role role, List<RoleFunction> roleFunctions) {
        roleDao.save(role);
        roleFunctionDao.save(roleFunctions);
        return 0;
    }

    public List<RoleFunction> findByRoleId(Integer roleId) {
        return roleFunctionDao.findByRoleId(roleId);
    }

    public int update(Role role) {
        return roleDao.update(role);
    }
}
