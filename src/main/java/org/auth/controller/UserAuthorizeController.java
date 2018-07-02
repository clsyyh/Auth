package org.auth.controller;

import org.auth.service.RoleService;
import org.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAuthorizeController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;
    /*
    跳转到授权首页
     */
    /*
    @RequestMapping("/authorize_list")
    public String index(){
        return "authorize_list";
    }
    */
    /*
    跳转到用户角色首页
     */
    /*
    @RequestMapping("/user_list")
    public String user_index(){
        return "user_list";
    }
    */
}
