package com.cong.coj.judge.strategy;

import com.cong.coj.model.dto.question.JudgeCase;
import com.cong.coj.judge.codesandbox.mode.JudgeInfo;
import com.cong.coj.model.entity.Question;
import com.cong.coj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文信息
 * @author 86188
 * @date 2023/09/02
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;
    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;
    /**
     * 题目提交信息
     */
    private QuestionSubmit questionSubmit;
}
