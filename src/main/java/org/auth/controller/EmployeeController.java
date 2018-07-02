package org.auth.controller;

import org.auth.entity.Dept;
import org.auth.entity.Employee;
import org.auth.entity.Role;
import org.auth.service.HrmServise;
import org.auth.service.RoleService;
import org.auth.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    @Qualifier("hrmService")
    private HrmServise hrmService;
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;
    //默认值
    private int pageSize=3;
    private int pageNum=1;

    @RequestMapping("/selectEmployeeByPage")
    public String selectEmployeeByPage(@RequestParam("pageNum") String pNum,
                               //@RequestParam("pageSize") String pSize,
                               Model model){
        if(pNum!=null&&!pNum.equals("")){
            pageNum=Integer.parseInt(pNum);
        }
        /*
        if(pSize!=null&&!pSize.equals("")){
            pageSize=Integer.parseInt(pSize);
        }
        */
        //查询到所有员工信息sourceList(每次都得全部查询一遍，需要优化？？？？？)
        List<Employee> sourceList=hrmService.findAllEmployees();

        //创建Pager类对象即"当前页对象"，传递sourceList
        Pager<Employee> pager=new Pager<Employee>(pageNum,pageSize,sourceList);

        model.addAttribute("pager",pager);
        return "employee";
    }

    @RequestMapping("/getImage")
    public void  getImage(Integer id,
                          HttpServletResponse response){
        Employee employee=hrmService.findEmployeeById(id);
        byte[] zp=employee.getZp();
        response.setContentType("image/jpeg");
        try {
            //得到输出流
            ServletOutputStream os = response.getOutputStream();
            //输出
            if(zp!=null&&zp.length>0){
                for(int i=0;i<zp.length;i++){
                    os.write(zp[i]);
                }
            }
        }catch(IOException e){
            throw new RuntimeException("出现错误",e);
        }
    }
    @RequestMapping("updateEmployee")
    public  String updateEmployee(@ModelAttribute Employee employee,
                                  Model model){
        List<Dept> depts=hrmService.findAllDept();
        List<Role> jobs=roleService.findAllRoles();
        Employee emp=hrmService.findEmployeeById(employee.getId());
        List<Employee> target=new ArrayList<Employee>();
        target.add(emp);
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        model.addAttribute("target",target);
        return "showUpdateEmployee";
    }
    @RequestMapping("/updateEmployee1")
    public ModelAndView updateEmployee1( Integer deptId,
                                         @RequestParam("zpFile") MultipartFile zpFile,
                                         Integer jobId,
                                         @ModelAttribute Employee employee,
                                         ModelAndView mv){
        /*
        两次请求的参数个数不同
        if(flag.equals("1")){
            List<Dept> depts=hrmService.findAllDept();
            List<Role> jobs=roleService.findAllRoles();
            Employee target=hrmService.findEmployeeById(employee.getId());
            mv.setViewName("showUpdateEmployee");
            mv.addObject("target",target);
            mv.addObject("depts",depts);
            mv.addObject("jobs",jobs);
        }else {

        }
        */

        //①照片
        if(zpFile!=null){
            try {
                /*
                //得到输入流
                FileInputStream fis = new FileInputStream(zpFile);//zpFile是File类型
                System.out.println(fis+"|||||||||");
                byte[] buffer=new byte[fis.available()] ;
                fis.read(buffer);
                */
                byte[] buffer=zpFile.getBytes();
                //设置属性zp
                employee.setZp(buffer);
            }catch (IOException e){
                throw new RuntimeException("出现错误",e);
            }
        }
        //②部门和工作
        Dept dept=hrmService.findDeptById(deptId);
        Role job =roleService.findRoleById(jobId);
        employee.setDept(dept);
        employee.setJob(job);
        hrmService.modifyEmployee(employee);
        /*
        在更新完成后跳转到selectEmployeeByPage请求时也得传递参数值
         */
        mv.setViewName("redirect:/selectEmployeeByPage?pageNum=1");
        return mv;
    }
    @RequestMapping("/selectEmployee")
    //模糊查询
    public String selectUser(Integer job_id,//******Integer和String之间不需要类型转换******
                             Integer dept_id,//职位，所属部门
                             @ModelAttribute Employee employee,//姓名，性别等
                             Model model){
        /*
        ??????????????
        this.genericAssociation(job_id,dept_id,employee);
        */
        List<Employee> employees=hrmService.findEmployee(employee);
        model.addAttribute("employees",employees);
        return "employees";
    }

}
