package com.cong.coj.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户更新个人信息请求
 *
 * @author <a href="https://github.com/licong">程序员聪</a>
 * @from <a href="https://cong.icu">编程导航知识星球</a>
 */
@Data
public class UserUpdateMyRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 简介
     */
    private String userProfile;

    private static final long serialVersionUID = 1L;
}