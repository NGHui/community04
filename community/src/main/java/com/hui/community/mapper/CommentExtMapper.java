package com.hui.community.mapper;

import com.hui.community.model.Comment;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/18
 */
public interface CommentExtMapper {

    int incCommentCount(Comment comment);
}
