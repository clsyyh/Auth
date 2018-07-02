package org.auth.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.auth.entity.Function;
import org.auth.entity.RoleFunction;
import org.auth.entity.User;
import org.auth.entity.UserRole;
import org.auth.service.FunctionService;
import org.auth.service.RoleService;
import org.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;
    @Autowired
    @Qualifier("functionService")
    private FunctionService functionService;

    @RequestMapping("/{loginForm}")
    public String loginForm(@PathVariable String loginForm){
        return loginForm;
    }

    @RequestMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("pwd") String pwd,
                        @RequestParam("roleId") String roleId,
                        HttpSession session,
                        Model model){
        /*
        ***以不同的身份登陆，就在不同的表中查询是否存在该用户***
         */
        User user=userService.login(name,pwd);
        if(user==null){
            return "loginForm";
        }
        else{
            session.setAttribute("user",user);
            /*
            ***省略掉user_role表，并简化role_function表***
             */
            Map<String,Object> funs=new HashMap<String, Object>();
            int rid=Integer.parseInt(roleId);
            funs=getAccordions(rid);
            /*
            在登陆成功后获取该用户的所有权限
            存到session中，然后在前台展示
             */
            /*
            //管理员身份登录
            if(name.equals("admin")){
                funs=getAccordions(true,null);
            }
            //普通用户身份登录
            else{
                Integer userId = user.getId();
                List<UserRole> userRoles = userService.findByUserId(userId);
                //当该用户没有对应的角色时返回登录页面重新登录
                if (userRoles == null || userRoles.size() == 0) {
                    model.addAttribute("message", "用户未被授权！");
                    return "loginForm";
                }
               funs=getAccordions(false,userId);
            }
            */
            session.setAttribute("funs",funs);
            return "main";
        }
    }

    private Map<String,Object> getAccordions(int rid){
        Map<String,Object> funs=new HashMap<String, Object>();
        List<RoleFunction> roleFunctions = roleService.findByRoleId(rid);
        for (RoleFunction roleFunction : roleFunctions) {
            Integer functionId = roleFunction.getFunctionId();
            Function function = functionService.findFunctionById(functionId);
            String url = function.getUrl();
            String name=function.getName();
            funs.put(name,url);
        }
        return  funs;
    }

    /*
    private Map<String,Object> getAccordions(Boolean isAdmin,Integer userId){
        Map<String,Object> funs=new HashMap<String, Object>();
        if(isAdmin){
            List<Function> functions=functionService.findAllFunctions();
            for(Function function:functions){
                String url=function.getUrl();
                String name=function.getName();
                System.out.println(name+"----");
                funs.put(name,url);
            }
        }else {
            List<UserRole> userRoles = userService.findByUserId(userId);
            for (UserRole userRole : userRoles) {
                Integer roleId = userRole.getRoleId();
                List<RoleFunction> roleFunctions = roleService.findByRoleId(roleId);

                for (RoleFunction roleFunction : roleFunctions) {
                    Integer functionId = roleFunction.getFunctionId();
                    Function function = functionService.findFunctionById(functionId);
                    String url = function.getUrl();
                    String name=function.getName();
                    funs.put(name,url);
                }
            }
        }
        return  funs;
    }
   */
}
