package org.auth.controller;

import org.apache.commons.io.FileUtils;
import org.auth.entity.Document;
import org.auth.entity.User;
import org.auth.service.HrmServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
public class DocumentController {
    @Autowired
    @Qualifier("hrmService")
    private HrmServise hrmService;

    @RequestMapping("/selectDocument")
    public String selectDocument(@ModelAttribute Document document,
                                 Model model){
        List<Document> documents=hrmService.findDocument(document);
        model.addAttribute("documents",documents);
        return "document";
    }

    @RequestMapping("/addDocument")
    public ModelAndView addDocument(@RequestParam("flag") String flag,
                                    @ModelAttribute Document document,
                                    ModelAndView mv,
                                    HttpSession session)throws Exception{
        if(flag.equals("1")){
            mv.setViewName("showAddDocument");
        }
        if(flag.equals("2")){
            System.out.println("++++++++++++"+flag);
            //①上传文件
            String path=session.getServletContext().getRealPath("/upload/");
            String filename=document.getFile().getOriginalFilename();

            File filePath=new File(path,filename);
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }

            document.getFile().transferTo(new File(path+File.separator+filename));
            //②插入到数据库
            document.setFilename(filename);
            User user=(User)session.getAttribute("user");
            document.setUser(user);
            hrmService.addDocument(document);

            mv.setViewName("redirect:/selectDocument");
        }
        return mv;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(Integer id,
                                           HttpSession session)throws Exception{

        Document target=hrmService.findDocumentById(id);
        String filename=target.getFilename();
        String path=session.getServletContext().getRealPath("/upload");
        File file=new File(path+File.separator+filename);

        HttpHeaders headers=new HttpHeaders();
        String downloadFilename=new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",downloadFilename);

        byte[] bytes= FileUtils.readFileToByteArray(file);
        //将文件读到内存中后便可以删除文件了，以免下载的文件在本地积压
        try{
            if(file.exists()){
                file.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
    }
    @RequestMapping("/removeDocument")
    public ModelAndView removeDocument(@RequestParam("ids") String ids,
                                       ModelAndView mv){
        String[] idArray=ids.split(",");
        for(String id:idArray){
            hrmService.removeDocumentById(Integer.parseInt(id.equals("")?"0":id));
        }
        mv.setViewName("redirect:/selectDocument");
        return mv;
    }
    @RequestMapping("/updateDocument")
    public ModelAndView updateDocument(@RequestParam("flag") String flag,
                                       @ModelAttribute Document document,
                                       ModelAndView mv){
        if(flag.equals("1")){
            Document target=hrmService.findDocumentById(document.getId());
            mv.addObject("document",target);
            mv.setViewName("showUpdateDocument");
        }
        else{
            System.out.println(document.getTitle()+"------------");
            hrmService.modifyDocument(document);
            System.out.println("==============");
            mv.setViewName("redirect:selectDocument");
        }
        return mv;
    }
}
