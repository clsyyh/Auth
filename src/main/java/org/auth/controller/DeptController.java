package org.auth.controller;

import org.auth.entity.Dept;
import org.auth.service.HrmServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class DeptController {
    @Autowired
    @Qualifier("hrmService")
    private HrmServise hrmService;

    @RequestMapping("/selectDept")
    public String  selectDept(Model model){
        List<Dept> depts=hrmService.findAllDept();
        model.addAttribute("depts",depts);
        return "dept";
    }
    @RequestMapping("/updateDept")
    public ModelAndView updateDept(@RequestParam("flag") String flag,
                                   @ModelAttribute Dept dept,//获取id值？？？是否需要数据类型转换
                                   ModelAndView mv){
        if(flag.equals("1")){
            Dept target=hrmService.findDeptById(dept.getId());
            mv.addObject("dept",target);
            mv.setViewName("showUpdateDept");
            return mv;
        }else{
            hrmService.modifyDept(dept);
            mv.setViewName("redirect:selectDept");
            return mv;
        }
    }
    @RequestMapping("/addDept")
    public ModelAndView addDept(@RequestParam("flag") String flag,
                                @ModelAttribute Dept dept,
                                ModelAndView mv){
        if(flag.equals("1")){
            mv.setViewName("showAddDept");
        }else{
            hrmService.addDept(dept);
            mv.setViewName("redirect:selectDept");
        }
        return mv;
    }
    @RequestMapping("/removeDept")
    public ModelAndView removeDept(@RequestParam("ids") String ids,
                                   ModelAndView mv){
        String[] idArray=ids.split(",");
        for(String id:idArray){
            if(id.equals("")){
                System.out.println("----");
            }
            hrmService.removeDeptById(Integer.parseInt(id.equals("")?"0":id));
        }
        mv.setViewName("redirect:selectDept");
        return mv;
    }
}
