package com.hui.community.dto;

import com.hui.community.model.User;
import lombok.Data;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/10
 */
@Data
public class QuestionDTO {
    private Long id;

    private String title;

    private Long gmtCreate;

    private Long gmtModified;

    private Long creator;

    private Long commentCount;

    private Long viewCount;

    private Long likeCount;

    private String tag;

    private String description;

    private User user;

}
