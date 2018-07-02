package org.auth.service.imp;

import org.auth.dao.UserDao;
import org.auth.dao.UserRoleDao;
import org.auth.entity.User;
import org.auth.entity.UserRole;
import org.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    public User login(String name, String pwd) {
        return userDao.login(name,pwd);
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public int deleteUserById(Integer id) {
        userDao.deleteUserById(id);
        return userRoleDao.deleteByUserId(id);
    }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public List<User> findUsers(List<Integer> ids) {
        return userDao.findUsers(ids);
    }

    public List<UserRole> findUserRoles(List<Integer> ids) {
        return userRoleDao.findUserRoles(ids);
    }

    public List<UserRole> findByUserId(Integer userId) {
        return userRoleDao.findByUserId(userId);
    }

    public List<UserRole> findAllUserRoles() {
        return userRoleDao.findAllUserRoles();
    }

    public int saveUserRoles(List<UserRole> userRoles) {
        return userRoleDao.save(userRoles);
    }
    public int save(User user) {
        return userDao.save(user);
    }

}
