package com.cong.coj.judge;

import com.cong.coj.model.entity.QuestionSubmit;
import com.cong.coj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 * @author 86188
 * @date 2023/09/02
 */
public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return {@link QuestionSubmit*}
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
