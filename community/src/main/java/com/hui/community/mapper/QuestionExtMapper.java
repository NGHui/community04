package com.hui.community.mapper;

import com.hui.community.model.Question;
import com.hui.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    //查询阅读数
    int incView(Question record);

    //查询评论数
    void incCommentCount(Question question);
}