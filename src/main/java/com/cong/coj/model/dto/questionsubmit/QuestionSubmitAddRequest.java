package com.cong.coj.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/licong">程序员聪</a>
 * @from <a href="https://cong.icu">编程导航知识星球</a>
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;


}