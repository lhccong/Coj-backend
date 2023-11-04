package com.cong.coj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.cong.coj.model.dto.question.JudgeCase;
import com.cong.coj.model.dto.question.JudgeConfig;
import com.cong.coj.judge.codesandbox.mode.JudgeInfo;
import com.cong.coj.model.entity.Question;
import com.cong.coj.model.enums.JudgeInfoMessageEnum;

import java.util.List;
import java.util.Optional;

/**
 * 默认判题策略
 * @author 86188
 * @date 2023/09/02
 */
public class JavaLangugeJudgeStrategy implements JudgeStrategy {

    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {


        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCasesList = judgeContext.getJudgeCaseList();
        Question question = judgeContext.getQuestion();

        Long memory = Optional.ofNullable(judgeInfo.getMemoryLimit()).orElse(0L);
        Long time = Optional.ofNullable(judgeInfo.getTime()).orElse(0L);

        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemoryLimit(memory);
        judgeInfoResponse.setTime(time);

        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        //先判断沙箱执行的结果输出数量是否和预期输出数量相等
        if (inputList.size() != outputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        //依次判断每一项输出和预期输出是否相等
        for (int i = 0; i < judgeCasesList.size(); i++) {
            JudgeCase judgeCase = judgeCasesList.get(i);
            if (!judgeCase.getOutput().equals(outputList.get(i))) {
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }
        //判题题目限制

        String judgeConfigStr = question.getJudgeConfig();

        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long needTimeLimit = judgeConfig.getTimeLimit();
        Long needMemoryLimit = judgeConfig.getMemoryLimit();
        if (memory > needMemoryLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        //java程序本身需要执行多十秒
        long JAVA_PROGRAM_TIME_COST = 10000L;
        if ((time - JAVA_PROGRAM_TIME_COST) > needTimeLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }


        return judgeInfoResponse;
    }
}
