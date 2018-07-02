package org.auth.dao;

import org.auth.entity.Document;

import java.util.List;
import java.util.Map;

public interface DocumentDao {
    //动态分页查询(document&pageModel)
    List<Document> selectByPage(Map<String,Object> params);
    //动态查询文件总数(document)
    int count(Map<String,Object> params);
    Document selectById(int id);
    int deleteById(int id);
    //动态插入
    int save(Document document);
    //动态更新
    int update(Document document);
}
