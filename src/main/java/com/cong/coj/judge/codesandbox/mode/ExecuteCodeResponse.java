package com.cong.coj.judge.codesandbox.mode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author 86188
 * @date 2023/09/01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCodeResponse {

    /**
     *输出用例
     */
    private List<String> outputList;

    /**
     *执行信息
     */
    private String message;
    /**
     *执行状态
     */
    private Integer status;

    /**
     *判题信息
     */
    private JudgeInfo judgeInfo;
}
