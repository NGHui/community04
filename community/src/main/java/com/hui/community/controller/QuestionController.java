package com.hui.community.controller;

import com.hui.community.dto.CommentDTO;
import com.hui.community.dto.QuestionDTO;
import com.hui.community.exception.CommentTypeEnum;
import com.hui.community.service.CommentService;
import com.hui.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/12
 */
@Controller
public class QuestionController {

        @Autowired
        private QuestionService questionServiceImpl;

        @Autowired
        private CommentService commentServiceImpl;

        @GetMapping("/question/{id}")
        public String question(@PathVariable(name = "id") Long id,
                               Model model) {
            QuestionDTO questionDTO = questionServiceImpl.getById(id);
            List<CommentDTO> comments = commentServiceImpl.listByTargetId(id, CommentTypeEnum.QUESTION);
            //累加阅读数,每次页面刷新阅读数加一
            questionServiceImpl.incView(id);
            model.addAttribute("question", questionDTO);
            model.addAttribute("comments", comments);
            return "question";
        }

}
