package org.auth.service.imp;

import org.auth.dao.*;
import org.auth.entity.*;
import org.auth.service.HrmServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmServise {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private DocumentDao documentDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private CommentDao commentDao;
    //部门
    @Transactional(readOnly = true)
    public List<Dept> findDept(Dept dept) {
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("dept",dept);
        List<Dept> depts=deptDao.selectByPage(params);
        return depts;
    }
    @Transactional(readOnly = true)
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }
    @Transactional(readOnly = true)
    public Dept findDeptById(Integer id) {
        return deptDao.selectById(id);
    }

    public int removeDeptById(Integer id) {
        return deptDao.deleteById(id);
    }

    public int modifyDept(Dept dept) {
        return deptDao.update(dept);
    }

    public int addDept(Dept dept) {
        return deptDao.save(dept);
    }
    //员工
    @Transactional(readOnly = true)
    public List<Employee> findEmployee(Employee employee) {
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("employee",employee);
        List<Employee> employees=employeeDao.selectByPage(params);
        return employees;
    }

    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectById(id);
    }

    public int removeEmployeeById(Integer id) {
        return employeeDao.deleteById(id);
    }

    public int modifyEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    public int addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }
    //公告
    @Transactional(readOnly = true)
    public List<Notice> findNotice(Notice notice) {
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("notice",notice);
        List<Notice> notices=noticeDao.selectByPage(params);
        return notices;
    }
    @Transactional(readOnly = true)
    public Notice findNoticeById(Integer id) {
        return noticeDao.selectById(id);
    }

    public int removeNoticeById(Integer id) {
        return noticeDao.deleteById(id);
    }

    public int modifyNotice(Notice notice) {
        return noticeDao.update(notice);
    }

    public int addNotice(Notice notice) {
        return noticeDao.save(notice);
    }

    public List<Notice> findAllNotices() {
        return noticeDao.findAllNotices();
    }

    //文件
    @Transactional(readOnly = true)
    public List<Document> findDocument(Document document) {
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("document",document);
        List<Document> documents=documentDao.selectByPage(params);
        return documents;
    }
    @Transactional(readOnly = true)
    public Document findDocumentById(Integer id) {
        return documentDao.selectById(id);
    }

    public int removeDocumentById(Integer id) {
        return documentDao.deleteById(id);
    }

    public int modifyDocument(Document document) {
        return documentDao.update(document);
    }

    public int addDocument(Document document) {
        return documentDao.save(document);
    }
    //问题
    @Transactional(readOnly = true)
    public List<Question> findAllQuestions() {
        return questionDao.findAll();
    }
    public int addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }

    public Question selectQuestionById(Integer id) {
        return questionDao.selectById(id);
    }


    public Comment selectById(Integer id) {
        return commentDao.selectById(id);
    }

    public List<Comment> selectByQuestionId(Integer id) {
        return commentDao.selectByQuestionId(id);
    }

    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }
}
