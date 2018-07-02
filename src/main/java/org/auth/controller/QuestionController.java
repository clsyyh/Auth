package org.auth.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.auth.entity.Comment;
import org.auth.entity.Question;
import org.auth.entity.User;
import org.auth.service.HrmServise;
import org.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class QuestionController {
    private static  final org.apache.ibatis.logging.Log logger=LogFactory.getLog(QuestionController.class);
    @Autowired
    @Qualifier("hrmService")
    private  HrmServise hrmServise;
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/addQuestion")
    public void addQuestion(@ModelAttribute Question question,
                            HttpSession session,
                            HttpServletResponse response)throws Exception{
        User user=(User)session.getAttribute("user");
        int userId=user.getId();
        question.setUser(user);

        hrmServise.addQuestion(question);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("1");
        out.flush();
        out.close();
    }
    @RequestMapping("/selectQuestions")
    public void selectQuestions(HttpServletResponse response)throws Exception{
        List<Question> questions=hrmServise.findAllQuestions();
        for(Question question:questions){
            question.setCount(question.getComments().size());
        }

        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.addDateHeader("Expires",0);
        response.setContentType("text/html;charset=utf-8");

        String responseStr= JSON.toJSONString(questions);

        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();
    }
    @RequestMapping("/addComment")
    public void addComment(@ModelAttribute Comment comment,
                           HttpSession session,
                           HttpServletResponse response)throws Exception{
        System.out.println(comment.getComment());

        User user=(User)session.getAttribute("user");
        comment.setUser(user);

        hrmServise.addComment(comment);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
    @RequestMapping("/selectComments")
    public void selectComments(@RequestParam("questionId") Integer questionId,
                               HttpServletResponse response)throws Exception{
        List<Comment> comments=hrmServise.selectByQuestionId(questionId);

        response.setContentType("text/html;charset=utf-8");
        String responseStr=JSON.toJSONString(comments);

        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();

    }
}
