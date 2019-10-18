package com.hui.community.dto;

import lombok.Data;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/14
 */
@Data
public class CommentCreateDTO  {
    private Long parentId;
    private String content;
    private Integer type;
}
