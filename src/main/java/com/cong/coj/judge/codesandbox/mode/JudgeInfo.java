package com.cong.coj.judge.codesandbox.mode;

import lombok.Data;

/**
 * 题目判题信息
 *
 * @author 86188
 * @date 2023/08/13
 */
@Data
public class JudgeInfo {

    /**
     * 执行程序信息
     */
    String message;

    /**
     * 内存消耗
     */
    Long memoryLimit;

    /**
     * 消耗时间 ms
     */
    Long time;
}
