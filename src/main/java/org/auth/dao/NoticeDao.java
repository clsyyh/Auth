package org.auth.dao;

import org.auth.entity.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeDao {
    //动态分页查询(notice&pageModel)
    List<Notice> selectByPage(Map<String,Object> params);
    //动态查询公告总数(notice)
    int count(Map<String,Object> params);
    Notice selectById(int id);
    int deleteById(int id);
    //动态插入
    int save(Notice notice);
    //动态更新
    int update(Notice notice);
    //查询所有公告
    List<Notice> findAllNotices();
}
