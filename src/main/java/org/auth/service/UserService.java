package org.auth.service;

import org.auth.entity.User;
import org.auth.entity.UserRole;

import java.util.List;

public interface UserService {
    public User login(String name,String pwd);
    public int update(User user);
    public int deleteUserById(Integer id);
    public User findUserById(Integer id);
    public List<User> findUsers(List<Integer> ids);

    public  List<UserRole> findUserRoles(List<Integer> ids);
    public List<UserRole> findByUserId(Integer userId);
    public List<UserRole> findAllUserRoles();
    /*
    一个用户对应多个角色
    所有userRole的userId相同
   */
    public int save(User user);
    public int saveUserRoles(List<UserRole> userRoles);
}
