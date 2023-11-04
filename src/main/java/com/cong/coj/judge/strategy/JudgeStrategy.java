package com.cong.coj.judge.strategy;

import com.cong.coj.judge.codesandbox.mode.JudgeInfo;

/**
 *判题策略
 * @author 86188
 * @date 2023/09/02
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return {@link JudgeInfo}
     */
    JudgeInfo doJudge(JudgeContext judgeContext);

}
