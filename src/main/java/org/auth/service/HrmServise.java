package org.auth.service;

import org.auth.entity.*;

import java.util.List;

public interface HrmServise {
    /*
    //用户相关业务
    public User login(String loginname, String password);
    public User findUserById(Integer id);
    int removeUserById(Integer id);
    public int modifyUser(User user);
    public  int addUser(User user);
    List<User> findUser(User user);
    */
    //员工业务相关
    public List<Employee> findEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Employee findEmployeeById(Integer id);
    public int removeEmployeeById(Integer id);
    public int modifyEmployee(Employee employee);
    public int addEmployee(Employee employee);
    //部门业务相关
    public List<Dept> findDept(Dept dept);
    public List<Dept> findAllDept();
    public Dept findDeptById(Integer id);
    public int removeDeptById(Integer id);
    public int modifyDept(Dept dept);
    public int addDept(Dept dept);
    //职位相关业务
    /*
    public List<Job> findJob(Job job);
    public List<Job> fingAllJob();
    public  Job findJObById(Integer id);
    public int removeJobById(Integer id);
    public  int modifyJob(Job job);
    public  int addJob(Job job);
    */
    //公告业务相关
    public List<Notice> findNotice(Notice notice);
    public Notice findNoticeById(Integer id);
    public  int removeNoticeById(Integer id);
    public int modifyNotice(Notice notice);
    public int addNotice(Notice notice);
    public  List<Notice> findAllNotices();
    //文件业务相关
    public List<Document> findDocument(Document document);
    public Document findDocumentById(Integer id);
    public int removeDocumentById(Integer id);
    public int modifyDocument(Document document);
    public  int addDocument(Document document);
    //问题相关
    public List<Question> findAllQuestions();
    public int addQuestion(Question question);
    public Question selectQuestionById(Integer id);
    //评论相关
    public Comment selectById(Integer id);
    public List<Comment> selectByQuestionId(Integer id);
    public int addComment(Comment comment);

}
