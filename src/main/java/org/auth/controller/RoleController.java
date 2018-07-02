package org.auth.controller;

import org.auth.entity.Role;
import org.auth.entity.RoleFunction;
import org.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;


    @RequestMapping("/role_list")
    public String index(){
        return "role_List";
    }

    @RequestMapping("/selectRoles")
    public String selectRoles(Model model){
       List<Role> roles= roleService.findAllRoles();
       model.addAttribute("jobs",roles);
       return "job";
    }
    @RequestMapping("/getRoles")
    /*
    传递过来的参数ids是字符串
    传递出去的参数ids是List
     */
    public String getRoles(@RequestParam("ids") String ids,
                           Model model){
        String[] idArray=ids.split(",");
        List<Integer> lids=new ArrayList<Integer>();
        for(String id:idArray){
           Integer lid=Integer.parseInt(id);
           lids.add(lid);
        }
        List<Role> roles=roleService.findRoles(lids);
        model.addAttribute("roles",roles);
        return "";
    }
    /*
    Role{functionIds}
     */
    @RequestMapping("/saveRoleAndRoleFunctions")
    public String saveRolAndRoleFunction(@ModelAttribute Role role,
                                         Model model){
            String functionIds=role.getFunctionIds();
            String[] idArray=functionIds.split(",");
            List<RoleFunction> roleFunctions=new ArrayList<RoleFunction>();
            for(String id:idArray){
                Integer lid=Integer.parseInt(id);
                RoleFunction roleFunction=new RoleFunction();
                roleFunction.setFunctionId(lid);
                roleFunction.setRoleId(role.getId());
                roleFunctions.add(roleFunction);
            }
            roleService.save(role,roleFunctions);
        return "";
    }
    @RequestMapping("/deleteRoleAndRoleFunctions")
    public String deleteRoleAndRoleFunctions(@ModelAttribute Role role){
        roleService.deleteRoleById(role.getId());
        return "";
    }

}
