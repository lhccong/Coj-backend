package com.cong.coj.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 *
 * @author 86188
 * @date 2023/08/13
 */
@Data
public class JudgeConfig {

    /**
     * 时间限制 ms
     */
    Long timeLimit;

    /**
     * 内存限制 kb
     */
    Long memoryLimit;

    /**
     * 内存限制  kb
     */
    Long stackLimit;
}
