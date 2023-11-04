package com.cong.coj.judge.codesandbox.impl;

import com.cong.coj.judge.codesandbox.CodeSandbox;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;
import com.cong.coj.judge.codesandbox.mode.JudgeInfo;
import com.cong.coj.model.enums.JudgeInfoMessageEnum;
import com.cong.coj.model.enums.QuestionSubmitStatusEnum;

/**
 * 示例代码沙箱（示例仅为了跑通业务流程）
 * @author 86188
 * @date 2023/09/01
 */
public class ExampleCodeSandBox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("示例代码沙箱");
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(executeCodeRequest.getInputList());
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemoryLimit(100L);
        judgeInfo.setTime(100L);

        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }
}
