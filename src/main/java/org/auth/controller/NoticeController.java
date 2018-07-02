package org.auth.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.auth.entity.Notice;
import org.auth.service.HrmServise;
import org.auth.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    @Qualifier("hrmService")
    private HrmServise hrmService;

    //默认值
    private int pageSize=35;
    private int pageNum=1;

    private static List<String> fileTypes=new ArrayList<String>();
    static{
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }

    @RequestMapping("/selectNotice")
    //模糊查询
    public String selectNotice(@ModelAttribute Notice notice,//notice不为null
                             Model model){
        /*
        根据标题或内容模糊查询
         */
       if(notice.getContent()==null&&notice.getTitle()==null){
           notice=null;
       }
        List<Notice> notices=hrmService.findNotice(notice);

        for(Notice n:notices){
            System.out.println(n.getTitle());
        }
        model.addAttribute("notices",notices);
        return "notice";
    }
    @RequestMapping("/prevNotice")
    public String prevNotice(@ModelAttribute Notice notice,
                             Model model){
        Notice target=hrmService.findNoticeById(notice.getId());
        model.addAttribute("notice",target);
        return "prevNotice";
    }
    /*
    首先跳转到noticeByPage.jsp页面异步加载数据
     */
    @RequestMapping("/selectNoticeByPage")
    public void selectNoticeByPage(@RequestParam("pageNum") String pNum,//Ajax异步请求data传参
                                   @RequestParam("title") String title,
                                   HttpServletResponse response){
        List<Notice> notices=null;
        if(pNum!=null&&!pNum.equals("")) {
             pageNum = Integer.parseInt(pNum);
        }
        /*
        每一次请求都需要查询一次数据，有待优化？？？？？
         */
        if(title!=null&&!title.equals("")){
            //条件查询
            Notice notice=new Notice();
            notice.setTitle(title);
            notices=hrmService.findNotice(notice);

        }else {
            //查询所有
            notices = hrmService.findAllNotices();
        }
            System.out.println(notices.size());
        /*
        当notices长度为0时，没有执行new Pager语句？？？？？？？？
         */
            Pager<Notice> pager = new Pager<Notice>(pageNum, pageSize, notices);
            System.out.println(notices.size());
            System.out.println(pager+"***********");
            System.out.println(pager==null);
            System.out.println(pager.getTotalRecord());
            System.out.println(pager.getCurrentPage());
        /*
        响应json数据
         */
        /*
        response响应报头
         */
        //不使用缓存
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        //设置超时时间
        response.addDateHeader("Expires",0);
        //①***设置对客户端相应的MIME类型
        response.setContentType("text/html;charset=utf-8");
        //②***把对象转化为json字符串
        String responseStr= com.alibaba.fastjson.JSON.toJSONString(pager);
        //③***
        try {
            Writer writer = response.getWriter();
            writer.write(responseStr);
            writer.flush();
            writer.close();
            /*
            PrintWriter out=response.getWriter();
            out.println(responseStr);
            out.flush();
            out.close();
            */
        }catch(IOException e){
            throw  new RuntimeException("出现异常",e);
        }
    }
    @RequestMapping("/addNotice")
    public ModelAndView addNotice(@RequestParam("flag") String flag,
                                  @ModelAttribute Notice notice,
                                  ModelAndView mv){
        if(flag.equals("1")){
            mv.setViewName("showAddNotice");
        }else{
            System.out.println(notice.getTitle());
            System.out.println(notice.getContent());
            hrmService.addNotice(notice);
            mv.setViewName("redirect:selectNotice");
        }
        return mv;
    }
    @RequestMapping("/uploadImage")
    public void uploadImg(@RequestParam("upload") MultipartFile file,
                          HttpSession session,
                          HttpServletRequest request,
                          HttpServletResponse response)throws Exception{

        System.out.println("**********");
        System.out.println(file.isEmpty());
        PrintWriter out=response.getWriter();
        /*
        上传成功，但是出现错误:Incorrect server response.????????
        CKEditorFuncNum==null?????
         */
        /*
        response.setContentType("text/html;charset=utf-8");
        //CKEditorFuncNum这个参数是用来回调页面的，就是上传成功后，页面自动切换到“图像”选项卡
        String callback = request.getParameter("CKEditorFuncNum");
        System.out.println(callback+"*********");
        */
        //上传路径的绝对路径
        String path=session.getServletContext().getRealPath("/upload/");
        String filename=file.getOriginalFilename();
        System.out.println(filename);
        //如果图片名称不为空说明该图片存在
        if(filename.trim()!=""){
            //获得图片后缀名称
            String suffix=filename.substring(filename.lastIndexOf(".")).toLowerCase();
            System.out.println(suffix+"********");
            if(!fileTypes.contains(suffix)){
                /*
                out.println("<script type=\\\"text/javascript\\\">");
                out.println("window.parent.CKEDITOR.tools.callFunction("+callback+",'',"+"'文件格式不正确（必须为图片）');");
                out.println("</script>");
                */
                return;
            }
        }

        File filePath=new File(path,filename);
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }

        file.transferTo(new File(path+File.separator+filename));

        String imageContextPath=request.getContextPath()+path+filename;
        System.out.println(imageContextPath+"********");
        /*
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                + ",'" + request.getContextPath() + imageContextPath + "','')");
        out.println("</script>");
        out.flush();
        out.close();
        */
    }

}
