package org.auth.controller;

import org.auth.entity.Function;
import org.auth.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunctionController {
    @Autowired
    @Qualifier("functionService")
    private FunctionService functionService;

    @RequestMapping("/function_list")
    public String index(){
        return "function_list";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute Function function){
        functionService.save(function);
        return "";
    }
    @RequestMapping("delete")
    public String delete(@ModelAttribute Function function){
        functionService.deleteFunctionById(function.getId());
        return "";
    }
    @RequestMapping("getSubFunctions")
    public String getSubFunctions(@ModelAttribute Function function){
        functionService.findSubFunctions(function.getParentId());
        return "";
    }

}
