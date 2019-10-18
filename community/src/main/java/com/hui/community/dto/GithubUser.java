package com.hui.community.dto;

import lombok.Data;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/7
 */
//网络数据传输模型
@Data
public class GithubUser {

    //github的账号id
    private Long id;
    //github的账号名
    private String name;
    //描述
    private String bio;
    //头像的地址
    private String avatar_url;

}
