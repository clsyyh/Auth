package org.auth.dao;

import org.auth.entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class QuestionDaoTest {
    @Resource
    private QuestionDao questionDao;
    @Test
    public void findAll() throws Exception {
        List<Question> questions=questionDao.findAll();
        for(Question question:questions){
            System.out.println(question.getTitle());
        }
    }

    @Test
    public void addQuestion() throws Exception {
    }

}