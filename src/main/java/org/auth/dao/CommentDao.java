package org.auth.dao;

import org.auth.entity.Comment;

import java.util.List;

public interface CommentDao {
    public Comment selectById(Integer id);
    public List<Comment> selectByQuestionId(Integer id);
    public int addComment(Comment comment);
}
