package org.auth.dao;

import org.auth.entity.Comment;
import org.auth.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CommentDaoTest {
    @Resource
    private CommentDao commentDao;
    @Test
    public void selectById() throws Exception {
        Comment comment=commentDao.selectById(1);
        System.out.println(comment.getComment());
    }

    @Test
    public void selectByQuestionId() throws Exception {
       List<Comment> comments=commentDao.selectByQuestionId(1);
       for(Comment comment:comments) {
           System.out.println(comment.getComment());
       }
    }

    @Test
    public void addComment() throws Exception {
        User user=new User();
        user.setId(7);
        user.setLoginname("jug");
        user.setPassword("stgklj");
        user.setStatus(1);

        Comment comment=new Comment();
        comment.setUser(user);
        comment.setComment("是否快乐时刻");
        comment.setQuestionId(1);

        commentDao.addComment(comment);


    }

}