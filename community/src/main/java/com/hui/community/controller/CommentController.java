package com.hui.community.controller;

import com.hui.community.dto.CommentCreateDTO;
import com.hui.community.dto.CommentDTO;
import com.hui.community.dto.ResultDTO;
import com.hui.community.exception.CommentTypeEnum;
import com.hui.community.exception.CustomizeErrorCode;
import com.hui.community.mapper.CommentMapper;
import com.hui.community.model.Comment;
import com.hui.community.model.User;
import com.hui.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/14
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO ,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        //设置初始阅读,评论数
        comment.setLikeCount(0L);
        comment.setCommentCount(0L);
        commentServiceImpl.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentServiceImpl.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}