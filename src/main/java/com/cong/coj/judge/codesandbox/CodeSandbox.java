package com.cong.coj.judge.codesandbox;

import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;

/**
 * 代码沙箱
 *
 * @author 86188
 * @date 2023/09/01
 */
public interface CodeSandbox {
    /**
     * 执行代码沙箱
     * @param executeCodeRequest
     * @return {@link ExecuteCodeResponse}
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
