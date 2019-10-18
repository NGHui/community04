package com.hui.community.service;

import com.hui.community.dto.CommentDTO;
import com.hui.community.exception.CommentTypeEnum;
import com.hui.community.model.Comment;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/14
 */
public interface CommentService {

    /**
     * 添加评论
     * @param comment
     */
    void insert(Comment comment);

    /**
     *查询评价类型
     * @param id
     * @param type
     * @return
     */
    List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type);

}
