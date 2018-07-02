package org.auth.dao;

import org.auth.entity.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-dao.xml"})
public class UserRoleDaoTest {
    @Resource
    private UserRoleDao userRoleDao;
    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findByUserId() throws Exception {
    }

    @Test
    public void deleteByRoleId() throws Exception {
    }

    @Test
    public void save() throws Exception {
        List<UserRole> userRoles=new ArrayList<UserRole>();
        UserRole userRole=new UserRole();
        userRole.setUserId((Integer) 1);
        userRole.setRoleId((Integer) 1);

        UserRole userRole1=new UserRole();
        userRole1.setUserId((Integer) 1);
        userRole1.setRoleId((Integer) 2);

        userRoles.add(userRole);
        userRoles.add(userRole1);
        userRoleDao.save(userRoles);
    }

    @Test
    public void findUserRoles() throws Exception {
        List<Integer> ids=new ArrayList<Integer>();
        ids.add((int)1);
        ids.add((int)2);
        List<UserRole> userRoles=userRoleDao.findUserRoles(ids);
        for(UserRole ur:userRoles){
            System.out.println(ur.getRoleId()+"---"+ur.getUserId());
        }
    }

}