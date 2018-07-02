package org.auth.dao;

import org.auth.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User login(String name,String pwd);
    public int update(User user);
    public int save(User user);
    public int deleteUserById(Integer id);
    public User findUserById(Integer id);
    public List<User> findUsers(List<Integer> ids);
}
