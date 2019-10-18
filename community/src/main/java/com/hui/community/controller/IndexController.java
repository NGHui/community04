package com.hui.community.controller;

import com.hui.community.dto.PaginationDTO;
import com.hui.community.mapper.UserMapper;
import com.hui.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/9/28
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionServiceImpl;

    @GetMapping("/")
    public String index(Model model,@RequestParam(name = "page", defaultValue = "1") Integer page,
                                    @RequestParam(name = "size", defaultValue = "1") Integer size){

        //遍历浏览器中的cookie,判断浏览器中是否有我们自己定义的token
        PaginationDTO pagination = questionServiceImpl.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
