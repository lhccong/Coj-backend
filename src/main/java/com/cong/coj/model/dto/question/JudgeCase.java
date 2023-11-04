package com.cong.coj.model.dto.question;

import lombok.Data;

/**
 * 题目用例
 *
 * @author 86188
 * @date 2023/08/13
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    String input;

    /**
     * 输出用例
     */
    String output;
}
