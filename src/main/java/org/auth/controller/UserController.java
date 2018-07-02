package org.auth.controller;

import org.apache.ibatis.annotations.Param;
import org.auth.entity.User;
import org.auth.entity.UserRole;
import org.auth.service.UserService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/user_list")
    public String  index(){
        return "user_list";
    }
    /*
    User{roleIds}
     */
    @RequestMapping("/saveUserAndUserRole")
    public String saveUserAndUserRole(@ModelAttribute User user){
        String roleIds=user.getRoleIds();
        String[] idArray=roleIds.split(",");
        List<UserRole> userRoles=new ArrayList<UserRole>();
        for(String id:idArray){
            Integer lid=Integer.parseInt(id);
            UserRole userRole=new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(lid);
            userRoles.add(userRole);
        }
        userService.save(user);
        userService.saveUserRoles(userRoles);
        return "";
    }
    @RequestMapping("/deleteUserAndUserRoles")
    public String deleteUserAndUserRoles(@ModelAttribute User user){
        userService.deleteUserById(user.getId());
        return "";
    }
    @RequestMapping("/getUsers")
    public String getUsers(@RequestParam("ids") String ids){
        String[] idArray=ids.split(",");
        List<Integer> lids=new ArrayList<Integer>();
        for(String id:idArray){
            Integer lid=Integer.parseInt(id);
            lids.add(lid);
        }
        userService.findUsers(lids);
        return "";
    }
    @RequestMapping("/getUserRolesByUserId")
    public String getUserRolesByUserId(@ModelAttribute User user,
                                       Model model){
        List<UserRole> userRoles=userService.findByUserId(user.getId());
        model.addAttribute("userRoles",userRoles);
        return "";
    }
    //查询所有的用户角色关系
    @RequestMapping("/authorize")
    public String authorize(Model model){
        List<UserRole> userRoles=userService.findAllUserRoles();
        model.addAttribute("userRoles",userRoles);
        return "";
    }
}
