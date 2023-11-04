package com.cong.coj.judge;

import com.cong.coj.judge.strategy.DefaultJudgeStrategy;
import com.cong.coj.judge.strategy.JavaLangugeJudgeStrategy;
import com.cong.coj.judge.strategy.JudgeContext;
import com.cong.coj.judge.strategy.JudgeStrategy;
import com.cong.coj.judge.codesandbox.mode.JudgeInfo;
import com.cong.coj.model.entity.QuestionSubmit;
import com.cong.coj.model.enums.QuestionSubmitLanguageEnum;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 * @author 86188
 * @date 2023/09/02
 */
@Service
public class JudgeManager {
    public JudgeInfo doJudge(JudgeContext judgeContext) {

        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if (QuestionSubmitLanguageEnum.JAVA.getText().equals(language)){
            judgeStrategy = new JavaLangugeJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
